package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;
import pl.coderslab.validation.ChildValidation;

import javax.jws.WebParam;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

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
        if (bindingResult.hasErrors()){
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
        childRepository.delete(id);
        return "redirect:/teacher/mainPage";
    }

    @GetMapping("/editchild/{id}")
    public String editChild(@PathVariable long id, Model model) {
        Child child = childRepository.findById(id);
        Child tempChild = new Child(child);
        model.addAttribute("child", child);
        model.addAttribute("tempChild",tempChild);

        return "teacher/editChild";
    }

    @PostMapping("/editchild/{id}")
    public String editChild(@ModelAttribute @Validated(ChildValidation.class) Child child, BindingResult bindingResult,@ModelAttribute("tempChild")Child tempChild) {
        if(bindingResult.hasErrors()){
            return "teacher/editChild";
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
