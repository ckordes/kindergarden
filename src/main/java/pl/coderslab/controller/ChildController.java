package pl.coderslab.controller;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.pojo.EmailServiceImpl;
import pl.coderslab.repository.*;
import pl.coderslab.validation.ChildValidation;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/child")
public class ChildController {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private AllergieRepository allergieRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ChildRelatedMessagesRepository childRelatedMessagesRepository;
    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private Validator validator;

    @ModelAttribute("allChildren")
    public List<Child> allChildren() {
        return childRepository.findAll();
    }

    @ModelAttribute("allParents")
    public List<Parent> allParents() {
        return parentRepository.findAll();
    }

    @ModelAttribute("allAllergies")
    public List<Allergie> allAllergies() {
        return allergieRepository.findAll();
    }

    @ModelAttribute("allGroups")
    public List<Group> allGroups() {
        return groupRepository.findAll();
    }

    @RequestMapping("/managechildren")
    public String manageChildren() {
        return "teacher/manageChildren";
    }

    @GetMapping("/createChild")
    public String createChild(Model model) {
        Child child = new Child();
        model.addAttribute("child", child);
        return "teacher/addChild";
    }

    @PostMapping("/createChild")
    public String createChild(@ModelAttribute @Validated(ChildValidation.class) Child child, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "teacher/addChild";
        }
        Person person = child.getPerson();
        Address address = person.getHomeAddress();
        addressRepository.save(address);
        personRepository.save(person);
        childRepository.save(child);
        updateParentRepo(child);
        updateGroupRepo(child);
        return "redirect:/teacher/mainPage";
    }

    @RequestMapping("/deleteChild/{id}")
    public String deleteChild(@PathVariable long id) {
        Child child = childRepository.findById(id);
        for (Group group : child.getGroupList()) {
            Group groupRepo = groupRepository.findById(group.getId());
            List<Child> childList = groupRepo.getChildList();
            childList.remove(child);
            groupRepository.save(groupRepo);
        }
        for (Parent parent : child.getParentList()) {
            Parent parentRepo = parentRepository.findById(parent.getId());
            List<Child> childList = parentRepo.getChildList();
            childList.remove(child);
            parentRepository.save(parentRepo);
        }
        for (ChildRelatedMessages message : child.getChildRelatedMessagesList()) {
            childRelatedMessagesRepository.delete(message.getId());
        }
        childRepository.delete(id);
        return "redirect:/teacher/mainPage";
    }

    @GetMapping("/editchild/{id}")
    public String editChild(@PathVariable long id, Model model, HttpSession httpSession) {
        Child child = childRepository.findById(id);
        String listOfParents = "";
        String listOfGroups = "";
        model.addAttribute("child", child);
        for (Parent parent : child.getParentList()) {
            listOfParents += parent.getId() + ",";
        }
        for(Group group : child.getGroupList()){
            listOfGroups+=group.getId() + ",";
        }
        httpSession.setAttribute("listOfParents", listOfParents);
        httpSession.setAttribute("listOfGroups", listOfGroups);
        return "teacher/editChild";
    }

    @PostMapping("/editchild/{id}")
    public String editChild(@ModelAttribute @Validated(ChildValidation.class) Child child, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "teacher/editChild";
        }
        String listOfParents = (String) httpSession.getAttribute("listOfParents");
        String listOfGroups = (String) httpSession.getAttribute("listOfGroups");
        String[] arrayGroups = listOfGroups.split(",");
        String[] arrayParents = listOfParents.split(",");
        List<Long> listParents = new ArrayList<>();
        List<Long> listGroups = new ArrayList<>();
        for (Parent parent : child.getParentList()) {
            listParents.add(parent.getId());
        }
        for(Group group:child.getGroupList()){
            listGroups.add(group.getId());
        }
        for (int i = 0; i < arrayParents.length; i++) {
            if (!listParents.contains(Long.valueOf(arrayParents[i]))) {
                Parent tempParent = parentRepository.findById(Long.valueOf(arrayParents[i]));
                List<Child> childList = tempParent.getChildList();
                childList.remove(childRepository.findById(child.getId()));
                parentRepository.save(tempParent);
            }
        }
        for (int i=0; i< arrayGroups.length;i++){
            if(!listGroups.contains(Long.valueOf(arrayGroups[i])));{
                Group tempGroup = groupRepository.findById(Long.valueOf(arrayGroups[i]));
                List<Child> childList = tempGroup.getChildList();
                childList.remove(childRepository.findById(child.getId()));
                groupRepository.save(tempGroup);
            }
        }
        Child childRepo = childRepository.findById(child.getId());

        Person person = child.getPerson();
        person.setId(childRepo.getPerson().getId());
        Address address = person.getHomeAddress();
        address.setId(childRepo.getPerson().getHomeAddress().getId());
        addressRepository.save(address);
        personRepository.save(person);
        childRepo.setParentList(child.getParentList());
        childRepo.setGroupList(child.getGroupList());
        childRepository.save(childRepo);
        updateParentRepo(childRepo);
        updateGroupRepo(childRepo);
        return "redirect:/teacher/mainPage";
    }

    @GetMapping("/displayChild/{id}")
    public String displayChild(@PathVariable long id, Model model) {
        Child child = childRepository.findById(id);
        ChildRelatedMessages childRelatedMessages = new ChildRelatedMessages();
        model.addAttribute("child", child);
        model.addAttribute("childRelatedMessages", childRelatedMessages);
        return "parent/displayChild";
    }

    @PostMapping("/displayChild/{id}")
    public String displayChild(@PathVariable long id, @ModelAttribute ChildRelatedMessages childRelatedMessages) {
        Child child = childRepository.findById(id);
        //adding email sending functionality
        Set<Person> personSet = new HashSet<>();
        for (Parent parent : child.getParentList()) {
            personSet.add(parent.getPerson());
        }
        for (Group group : child.getGroupList()) {
            for (Teacher teacher : group.getTeacherList()) {
                personSet.add(teacher.getPerson());
            }
        }
        for (Person person : personSet) {
            emailService.sendSimpleMessage(person.getEmail(), "New information related " + child.getFullName(),
                    childRelatedMessages.getMessage());
        }
        childRelatedMessages.setCreated(LocalDateTime.now());
        childRelatedMessages.setChild(child);
        childRelatedMessagesRepository.save(childRelatedMessages);
        childRelatedMessages = childRelatedMessagesRepository.findFirstByOrderByIdDesc();
        child.getChildRelatedMessagesList().add(childRelatedMessages);
        childRepository.save(child);
        return "redirect:/child/displayChild/" + child.getId();
    }

    private void updateParentRepo(Child child) {
        for (Parent parent : child.getParentList()) {
            Parent tempParent = parentRepository.findById(parent.getId());
            List<Child> childList = tempParent.getChildList();
            if (!childList.contains(child)) {
                childList.add(child);
            }
            tempParent.setChildList(childList);
            parentRepository.save(tempParent);
        }
    }

    private void updateGroupRepo(Child child) {
        for (Group group : child.getGroupList()) {
            Group tempGroup = groupRepository.findById(group.getId());
            List<Child> groupList = tempGroup.getChildList();
            if (!groupList.contains(child)) {
                groupList.add(child);
            }
            tempGroup.setChildList(groupList);
            groupRepository.save(tempGroup);
        }
    }
}
