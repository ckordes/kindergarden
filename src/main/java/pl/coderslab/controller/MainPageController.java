package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
import java.util.Collections;
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
    @Autowired
    private PersonRepository personRepository;

    @ModelAttribute (name = "generalInfo")
    public List<GeneralInfo> generalInfoList(){
        List<GeneralInfo> generalInfoList = generalInfoRepository.findAll();
        if (generalInfoList == null){
            generalInfoList = new ArrayList<>();
        }
        Collections.reverse(generalInfoList);
        return generalInfoList;
    }

    @GetMapping("/")
    public String homePage(Model model,HttpSession httpSession){
        LoginMode loginMode = new LoginMode();
        model.addAttribute("loginMode",loginMode);
        Object loggedUser = httpSession.getAttribute("loggedUser");
        if (loggedUser!=null){
            return "homePage";
        }
        return "home";
    }

    @PostMapping ("/")
    public String homePage (@ModelAttribute LoginMode loginMode,HttpSession httpSession){
       Person person = authenticationService.authenticate(loginMode.getEmail(),loginMode.getPassword());
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
           }else if (parent!=null){
               loggedUser = "parent";
               id = parent.getId();
               httpSession.setAttribute("loggedUser",loggedUser);
               httpSession.setAttribute("id",id);
               return "redirect:/parent/mainPage";
           }else{
               return "redirect:/";
           }
       }
    }

    @GetMapping("/changePassword")
    public String changePassword(Model model, HttpSession httpSession){
        Parent parent = parentRepository.findById((long) httpSession.getAttribute("id"));
        Teacher teacher = teacherRepository.findById((long)httpSession.getAttribute("id"));
        if(parent!=null){
            parent.getPerson().setPassword("");
            model.addAttribute("person",parent.getPerson());
            return "authentication/changePassword";
        }else if (teacher !=null){
            teacher.getPerson().setPassword("");
            model.addAttribute("person",teacher.getPerson());
            return "authentication/changePassword";
        }else {
            return "redirect:/";
        }
    }

    @PostMapping ("/changePassword")
    public String changePassword(@ModelAttribute("person") Person person,HttpSession httpSession){
        Parent parent = parentRepository.findById((long) httpSession.getAttribute("id"));
        Teacher teacher = teacherRepository.findById((long)httpSession.getAttribute("id"));
        if(parent!=null){
            String hashedPassword = BCrypt.hashpw(person.getPassword(), BCrypt.gensalt());
            person.setPassword(hashedPassword);
            personRepository.save(person);
            parent.setPerson(person);
            parentRepository.save(parent);
            return "redirect:/";
        }else {
            String hashedPassword = BCrypt.hashpw(person.getPassword(), BCrypt.gensalt());
            person.setPassword(hashedPassword);
            personRepository.save(person);
            teacher.setPerson(person);
            teacherRepository.save(teacher);
            return "redirect:/";
        }
    }

    @RequestMapping("/loggOff")
    public String loggOff(HttpSession httpSession){
        httpSession.removeAttribute("loggedUser");
        httpSession.removeAttribute("id");
        return "redirect:/";
    }


}

/*
        if (httpSession.getAttribute("loggedUser")==null){
            return "redirect:/authentication/login";
        }
 */