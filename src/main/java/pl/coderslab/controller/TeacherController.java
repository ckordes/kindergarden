package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public String addTeacher(@ModelAttribute Person person, @RequestParam String streetH, @RequestParam String buildingH,
                             @RequestParam String flatH, @RequestParam String zipH, @RequestParam String cityH,
                             @RequestParam String voievodyshipH, @RequestParam String streetW, @RequestParam String buildingW,
                             @RequestParam String flatW, @RequestParam String zipW, @RequestParam String cityW,
                             @RequestParam String voievodyshipW) {

        Address addressH = new Address(true, streetH, buildingH, flatH, Integer.parseInt(zipH), cityH, voievodyshipH);
        Address addressW = new Address(true, streetW, buildingW, flatW, Integer.parseInt(zipW), cityW, voievodyshipW);

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
    public String editTeacher(@ModelAttribute Teacher teacher, @PathVariable long id) {
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
    public String addParent(@ModelAttribute Parent parent) {
        Person person = parent.getPerson();
        Address homeAddress = parent.getPerson().getHomeAddress();
        Address workAddress = parent.getPerson().getWorkAddress();
        addressRepository.save(homeAddress);
        addressRepository.save(workAddress);
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
        Child child;
        List<Child> childList = parent.getChildList();
        for(Child childLoop : childList){
            List<Parent> parentsLoop = childLoop.getParentList();
            for (Parent parentLoop : parentsLoop){
                if (parent.getId()== parentLoop.getId()){
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
    public String editParent(@PathVariable long id, Model model){
        Parent parent = parentRepository.findById(id);
        model.addAttribute("parent",parent);
        return "/teacher/editParent";
    }
    @PostMapping("/editparent/{id}")
    public String editParent(@ModelAttribute Parent parent){
        Person person = parent.getPerson();
        Address homeAddress = person.getHomeAddress();
        Address workAddress = person.getWorkAddress();
        addressRepository.save(homeAddress);
        addressRepository.save(workAddress);
        personRepository.save(person);
        parentRepository.save(parent);
        return "redirect:/teacher/mainPage";
    }
}
