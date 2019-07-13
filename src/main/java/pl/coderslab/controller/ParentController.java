package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping("/mainPage")
    public String mainPage(Model model, HttpSession httpSession) {
        long parentId = (long) httpSession.getAttribute("id");
        Parent parent = parentRepository.findById(parentId);
        List<Child> childList = parent.getChildList();
        model.addAttribute("childList", childList);
        List<Group> groupList = new ArrayList<>();
        for (Child child : childList) {
            for (Group group : child.getGroupList()) {
                if (!groupList.contains(group)) {
                    groupList.add(group);
                }
            }
        }
        model.addAttribute("groupList", groupList);
        return "parent/mainPPage";
    }

    @RequestMapping("/groupInfo/{id}")
    public String groupInfors(@PathVariable long id, Model model) {
        Group group = groupRepository.findById(id);
        model.addAttribute("group", group);
        return "parent/displayGroupInfos";
    }
}
