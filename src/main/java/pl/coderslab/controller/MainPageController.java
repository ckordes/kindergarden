package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.GeneralInfo;
import pl.coderslab.entity.Parent;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Teacher;
import pl.coderslab.pojo.LoginMode;
import pl.coderslab.repository.GeneralInfoRepository;
import pl.coderslab.repository.ParentRepository;
import pl.coderslab.repository.PersonRepository;
import pl.coderslab.repository.TeacherRepository;
import pl.coderslab.service.AuthenticationService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    private GeneralInfoRepository generalInfoRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private ParentRepository parentRepository;

    @ModelAttribute (name = "generalInfo")
    public List<GeneralInfo> generalInfoList(){
        List<GeneralInfo> generalInfoList = generalInfoRepository.findAll();;
        if (generalInfoList == null){
            generalInfoList = new ArrayList<>();
        }
        return generalInfoList;
    }

    @GetMapping("/")
    public String homePage(Model model){
        LoginMode loginMode = new LoginMode();
        model.addAttribute("loginMode",loginMode);
        return "home";
    }

    @PostMapping ("/")
    public String homePage (@ModelAttribute LoginMode loginMode,HttpSession httpSession){
       Person person = authenticationService.checkPasswordForUser(loginMode.getEmail(),loginMode.getPassword());
       if (person == null) {
           return "redirect:/";
       }else {
           Teacher teacher = teacherRepository.findByPerson(person);
           Parent parent = parentRepository.findByPerson(person);
           String loggedUser ="";
           long id =0;
           if(teacher!=null){
               loggedUser="teacher";
               id = teacher.getId();
               httpSession.setAttribute("loggedUser",loggedUser);
               httpSession.setAttribute("id",id);
               return "redirect:/teacher/mainPage";
           }else {
               loggedUser = "parent";
               id = parent.getId();
               httpSession.setAttribute("loggedUser",loggedUser);
               httpSession.setAttribute("id",id);
               return "redirect:/parent/mainPage";
           }
       }
    }
}

/*
        if (httpSession.getAttribute("loggedUser")==null){
            return "redirect:/authentication/login";
        }
 */