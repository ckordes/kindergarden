package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Child;
import pl.coderslab.entity.Group;
import pl.coderslab.entity.Teacher;
import pl.coderslab.repository.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

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


    @RequestMapping("/mainPage")
    public String mainPage() {
        return "teacher/mainTPage";
    }

}
