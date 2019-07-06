package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private GroupInfoRepository groupInfoRepository;
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ChildRelatedMessagesRepository childRelatedMessagesRepository;









    @RequestMapping("/mainPage")
    public String mainPage(Model model, HttpSession httpSession) {
        long parentId = (long)httpSession.getAttribute("id");
        Parent parent = parentRepository.findById(parentId);
        List<Child> childList = parent.getChildList();
        model.addAttribute("childList",childList);
        List<Group> groupList = new ArrayList<>();
        for(Child child : childList){
            for (Group group :child.getGroupList()){
                if (!groupList.contains(group)){
                    groupList.add(group);
                }
            }

//            groupList.addAll(child.getGroupList());
        }
        model.addAttribute("groupList",groupList);

        return "parent/mainPPage";
    }

    @RequestMapping("/groupInfo/{id}")
    public String groupInfors(@PathVariable long id, Model model){
        Group group = groupRepository.findById(id);
        model.addAttribute("group",group);
        return "parent/displayGroupInfos";
    }

    @GetMapping("/displayChild/{id}")
    public String displayChild(@PathVariable long id, Model model){
        Child child = childRepository.findById(id);
        ChildRelatedMessages childRelatedMessages= new ChildRelatedMessages();
        model.addAttribute("child",child);
        model.addAttribute("childRelatedMessages",childRelatedMessages);
        return "parent/displayChild";

    }

    @PostMapping ("/displayChild/{id}")
    public String displayChild(@PathVariable long id, @ModelAttribute ChildRelatedMessages childRelatedMessages){
        Child child = childRepository.findById(id);
        childRelatedMessages.setCreated(LocalDateTime.now());
        childRelatedMessages.setChild(child);
        childRelatedMessagesRepository.save(childRelatedMessages);
        childRelatedMessages = childRelatedMessagesRepository.findFirstByOrderByIdDesc();
        child.getChildRelatedMessagesList().add(childRelatedMessages);
        childRepository.save(child);


        return "redirect:/parent/displayChild/"+child.getId();

    }
/*
("/addChildInfo/{id}")
    public String addChildInfo
 */



//add here child info view and post method
/*
    @GetMapping("/addChildInfo/{id}")
    public String addChildInfo(@PathVariable long id,Model model){
        Child child = childRepository.findById(id);
        return  "parent/addChildInfo";
    }
*/



}
