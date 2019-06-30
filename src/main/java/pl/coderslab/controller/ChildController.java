package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/child")
public class ChildController {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private AllergieRepository allergieRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;

    @ModelAttribute("allChildren")
    public List<Child> allChildren(){
        return childRepository.findAll();
    }
    @ModelAttribute("allParents")
    public List<Parent> allParents(){
        return parentRepository.findAll();
    }
    @ModelAttribute("allAllergies")
    public List<Allergie> allAllergies(){
        return allergieRepository.findAll();
    }
    @ModelAttribute("allGroups")
    public List<Group> allGroups(){
        return groupRepository.findAll();
    }

    @RequestMapping("/managechildren")
    public String manageChildren(){
        return "teacher/manageChildren";
    }

    @GetMapping("/createChild")
    public String createChild(Model model){
        Child child = new Child();
        model.addAttribute("child",child);
        return "teacher/addChild";
    }
    @PostMapping("/createChild")
    public String createChild(@ModelAttribute Child child){
        Person person = child.getPerson();
        Address address = person.getHomeAddress();
        addressRepository.save(address);
        personRepository.save(person);
        childRepository.save(child);
        return "redirect:/teacher/mainPage";
    }

    @RequestMapping("/deleteChild/{id}")
    public String deleteChild(@PathVariable long id){
        childRepository.delete(id);
        return "redirect:/teacher/mainPage";
    }

    @GetMapping("/editchild/{id}")
    public String editChild(@PathVariable long id, Model model){
        Child child = childRepository.findById(id  );
        model.addAttribute("child",child);
        return "teacher/editChild";
    }
    @PostMapping("/editchild/{id}")
    public String editChild(@ModelAttribute Child child){
        Person person = child.getPerson();
        Address address = person.getHomeAddress();
        addressRepository.save(address);
        personRepository.save(person);
        childRepository.save(child);
        return "redirect:/teacher/mainPage";
    }

}
