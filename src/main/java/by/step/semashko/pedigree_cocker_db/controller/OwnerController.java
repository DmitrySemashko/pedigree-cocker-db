package by.step.semashko.pedigree_cocker_db.controller;

import by.step.semashko.pedigree_cocker_db.model.entiy.Dog;
import by.step.semashko.pedigree_cocker_db.model.entiy.Owner;
import by.step.semashko.pedigree_cocker_db.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public String listDog(Model model){
        List<Owner> dogList = ownerService.findAll();
        model.addAttribute("owner",dogList);
        return "owner";
    }
}
