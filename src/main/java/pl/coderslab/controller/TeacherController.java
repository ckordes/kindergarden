package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.pojo.EmailServiceImpl;
import pl.coderslab.repository.*;
import pl.coderslab.validation.AdultValidation;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GeneralInfoRepository generalInfoRepository;
    @Autowired
    private GroupInfoRepository groupInfoRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private EmailServiceImpl emailService;

    @ModelAttribute("allGroups")
    public List<Group> allGroups() {
        List<Group> groupList = groupRepository.findAll();
        return groupList;
    }

    @ModelAttribute("allChildren")
    public List<Child> allChildren() {
        List<Child> childList = childRepository.findAll();
        return childList;
    }

    @ModelAttribute("allTeachers")
    public List<Teacher> allTeachers() {
        List<Teacher> teacherList = teacherRepository.findAll();
        return teacherList;
    }

    @ModelAttribute("allParents")
    public List<Parent> allParents() {
        List<Parent> parentList = parentRepository.findAll();
        return parentList;
    }

    @ModelAttribute(name = "allGeneralInfos")
    public List<GeneralInfo> allGeneralInfos() {
        List<GeneralInfo> generalInfoList = generalInfoRepository.findAll();
        ;
        if (generalInfoList == null) {
            generalInfoList = new ArrayList<>();
        }
        Collections.reverse(generalInfoList);
        return generalInfoList;
    }

    @RequestMapping("/mainPage")
    public String mainPage() {
        return "teacher/mainTPage";
    }

    @GetMapping("/addTeacher")
    public String addTeacher(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "teacher/addTeacher";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@ModelAttribute @Validated(AdultValidation.class) Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "teacher/addTeacher";
        }
        Address addressH = person.getHomeAddress(); //new Address(true, streetH, buildingH, flatH, Integer.parseInt(zipH), cityH, voievodyshipH);
        Address addressW = person.getWorkAddress(); //new Address(true, streetW, buildingW, flatW, Integer.parseInt(zipW), cityW, voievodyshipW);
        emailService.sendSimpleMessage(person.getEmail(), "Kindergarden infor: user created", "You have been added to teacher list. Default password is: " +
                person.getPassword() + " \n Please change your current password!");
        String hashedPassword = BCrypt.hashpw(person.getPassword(), BCrypt.gensalt());
        person.setPassword(hashedPassword);

        addressRepository.save(addressH);
        addressRepository.save(addressW);
        person.setWorkAddress(addressW);
        person.setHomeAddress(addressH);
        personRepository.save(person);

        Teacher teacher = new Teacher();
        teacher.setPerson(person);
        teacherRepository.save(teacher);
        return "redirect:mainPage";
    }

    @RequestMapping("/manageteachers")
    public String manageTeachers() {
        return "teacher/manageTeachers";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable long id) {
        Teacher teacher = teacherRepository.findById(id);
        Person person = teacher.getPerson();
        long homeAddressId = person.getHomeAddress().getId();
        long workAddressId = person.getWorkAddress().getId();
        person.setHomeAddress(null);
        person.setWorkAddress(null);
        long personId = teacher.getPerson().getId();
        teacher.setPerson(null);

        List<Group> groupList = groupRepository.findAll();
        for (Group group : groupList) {
            List<Teacher> teacherList = group.getTeacherList();
            for (Teacher teacherLoop : teacherList) {
                if (teacherLoop.getId() == teacher.getId()) {
                    teacherList.remove(teacher);
                    groupRepository.save(group);
                    break;
                }
            }
        }
        teacherRepository.delete(id);
        personRepository.delete(personId);
        addressRepository.delete(homeAddressId);
        addressRepository.delete(workAddressId);
        return "redirect:/teacher/mainPage";
    }

    @GetMapping("/editteacher/{id}")
    public String editTeacher(@PathVariable long id, Model model) {
        Teacher teacher = teacherRepository.findById(id);
        model.addAttribute("teacher", teacher);
        return "teacher/editTeacher";
    }

    @PostMapping("/editteacher/{id}")
    public String editTeacher(@ModelAttribute @Validated(AdultValidation.class) Teacher teacher, BindingResult bindingResult, @PathVariable long id) {
        if (bindingResult.hasErrors()) {
            return "teacher/editTeacher";
        }
        Person person = teacher.getPerson();
        Address homeAddress = person.getHomeAddress();
        Address workAddress = person.getWorkAddress();
        addressRepository.save(homeAddress);
        addressRepository.save(workAddress);
        personRepository.save(person);
        teacherRepository.save(teacher);
        return "redirect:/teacher/mainPage";
    }


    @RequestMapping("/manageparents")
    public String manageparents() {
        return "/teacher/manageParents";
    }

    @GetMapping("/addParent")
    public String addParent(Model model) {
        Parent parent = new Parent();
        model.addAttribute("parent", parent);
        return "/teacher/addParent";
    }

    @PostMapping("/addParent")
    public String addParent(@ModelAttribute("parent") @Validated(AdultValidation.class) Parent parent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/teacher/addParent";
        }
        Person person = parent.getPerson();
        emailService.sendSimpleMessage(person.getEmail(), "Kindergarden infor: user created", "You have been added to teacher list. Default password is: " +
                person.getPassword() + " \n Please change your current password!");
        Address homeAddress = parent.getPerson().getHomeAddress();
        Address workAddress = parent.getPerson().getWorkAddress();
        addressRepository.save(homeAddress);
        addressRepository.save(workAddress);
        String hashedPassword = BCrypt.hashpw(person.getPassword(), BCrypt.gensalt());
        person.setPassword(hashedPassword);
        personRepository.save(person);
        parentRepository.save(parent);
        return "redirect:/teacher/mainPage";
    }

    @RequestMapping("/deleteparent/{id}")
    public String deleteParent(@PathVariable long id) {
        Parent parent = parentRepository.findById(id);
        Person person = parent.getPerson();
        Address homeAddress = person.getHomeAddress();
        Address workAddress = person.getWorkAddress();
        List<Child> childList = parent.getChildList();
        for (Child childLoop : childList) {
            List<Parent> parentsLoop = childLoop.getParentList();
            for (Parent parentLoop : parentsLoop) {
                if (parent.getId() == parentLoop.getId()) {
                    parentsLoop.remove(parent);
                    childRepository.save(childLoop);
                    break;
                }
            }
        }
        person.setWorkAddress(null);
        person.setHomeAddress(null);
        parent.setChildList(null);
        parent.setPerson(null);
        parentRepository.delete(parent);
        personRepository.delete(person);
        addressRepository.delete(homeAddress);
        addressRepository.delete(workAddress);
        return "redirect:/teacher/mainPage";
    }

    @GetMapping("/editparent/{id}")
    public String editParent(@PathVariable long id, Model model) {
        Parent parent = parentRepository.findById(id);
        model.addAttribute("parent", parent);
        return "/teacher/editParent";
    }

    @PostMapping("/editparent/{id}")
    public String editParent(@ModelAttribute @Validated(AdultValidation.class) Parent parent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/teacher/editParent";
        }
        Person person = parent.getPerson();
        Address homeAddress = person.getHomeAddress();
        Address workAddress = person.getWorkAddress();
        addressRepository.save(homeAddress);
        addressRepository.save(workAddress);
        personRepository.save(person);
        parentRepository.save(parent);
        return "redirect:/teacher/mainPage";
    }

    @GetMapping("/addGroupInfo/{id}")
    public String addGroupInfo(@PathVariable long id, Model model) {
        GroupInfo groupInfo = new GroupInfo();
        model.addAttribute("groupInfo", groupInfo);
        return "group/addGroupInfo";
    }

    @PostMapping("/addGroupInfo/{id}")
    public String addGroupInfo(@ModelAttribute @Valid GroupInfo groupInfo, BindingResult bindingResult, @PathVariable long id) {
        if (bindingResult.hasErrors()) {
            return "group/addGroupInfo";
        }
        groupInfo.setCreated(LocalDateTime.now());
        groupInfoRepository.save(groupInfo);
        GroupInfo newGroupInfo = groupInfoRepository.findFirstByOrderByIdDesc();
        Group group = groupRepository.findById(id);
        List<GroupInfo> groupInfoList = group.getGroupInfoList();
        groupInfoList.add(newGroupInfo);
        groupRepository.save(group);
        //adding functionality to send mail when new group info is being created
        Set<Person> personList = new HashSet<>();
        for (Child child : group.getChildList()) {
            for (Parent parent : child.getParentList()) {
                personList.add(parent.getPerson());
            }
        }
        for (Person person : personList) {
            emailService.sendSimpleMessage(person.getEmail(), "New Group Info", groupInfo.getMessage());
        }

        String retrunString = "/group/displayGroup/" + String.valueOf(id);
        return "redirect:" + retrunString;
    }

    @RequestMapping("/childInfo/{id}")
    public String childInfo(@PathVariable long id, Model model) {
        Child child = childRepository.findById(id);
        model.addAttribute("child", child);
        return "parent/displayChildInfos";
    }

    @GetMapping("/addGeneralInfo")
    public String addGeneralInfo(Model model) {
        GeneralInfo generalInfo = new GeneralInfo();
        model.addAttribute("generalInfo", generalInfo);
        return "teacher/addGeneralInfo";
    }

    @PostMapping("/addGeneralInfo")
    public String addGeneralInfo(@ModelAttribute @Valid GeneralInfo generalInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "teacher/addGeneralInfo";
        }
        generalInfo.setCreated(LocalDateTime.now());
        generalInfoRepository.save(generalInfo);
        return "redirect:/teacher/mainPage";
    }

    @RequestMapping("/deleteGeneralInfo/{id}")
    public String deleteGeneralInfo(@PathVariable long id) {
        generalInfoRepository.delete(id);
        return "redirect:/teacher/addGeneralInfo";
    }
}
