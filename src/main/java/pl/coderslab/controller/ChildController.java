package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.GroupRepository;
import pl.coderslab.repository.ParentRepository;

@Controller
@RequestMapping("/child")
public class ChildController {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private GroupRepository groupRepository;


    @RequestMapping("/managechildren")
    public String manageChildren(){
        return "teacher/manageChildren";
    }

}
