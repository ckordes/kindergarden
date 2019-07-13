package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Child;
import pl.coderslab.entity.Group;
import pl.coderslab.entity.Teacher;
import pl.coderslab.repository.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
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

//    @RequestMapping("/mainPage")
//    public String mainPage() {
//        return "group/mainTPage";
//    }

    @GetMapping("/addgroup")
    public String addGroup(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "/group/addGroup";
    }

    @PostMapping("/addgroup")
    public String addGroup(@ModelAttribute @Valid Group group, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/group/addGroup";
        }
        groupRepository.save(group);
        return "redirect:/teacher/mainPage";
    }

    @GetMapping("/editgroup/{id}")
    public String editGroup(@PathVariable long id, Model model) {
        Group group = groupRepository.findById(id);
        model.addAttribute("group", group);
        return "group/editGroup";
    }

    @PostMapping("/editgroup/{id}")
    public String editGroup(@ModelAttribute Group group) {
        groupRepository.save(group);
        return "redirect:/teacher/mainPage";
    }

    @GetMapping("/displayGroup/{id}")
    public String displayGroup(@PathVariable long id, Model model) {
        Group group = groupRepository.findById(id);
        model.addAttribute("group", group);
        return "group/displayGroup";
    }

    @RequestMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable long id) {
        groupRepository.delete(id);
        return "redirect:/teacher/mainPage";
    }
}
