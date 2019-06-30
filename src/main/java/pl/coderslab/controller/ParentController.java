package pl.coderslab.controller;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Child;
import pl.coderslab.entity.Parent;
import pl.coderslab.repository.ChildRepository;
import pl.coderslab.repository.GroupInfoRepository;

import java.util.List;

@Controller
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private GroupInfoRepository groupInfoRepository;
    @Autowired
    private ChildRepository childRepository;

    @ModelAttribute("allChildren")
    public List<Child> allChildren(){
        return childRepository.findAll();
    }







    @RequestMapping("/mainPage")
    public String mainPage() {
        return "parent/mainPPage";
    }

}
