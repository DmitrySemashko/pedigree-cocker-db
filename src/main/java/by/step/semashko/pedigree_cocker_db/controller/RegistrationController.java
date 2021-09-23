package by.step.semashko.pedigree_cocker_db.controller;

import by.step.semashko.pedigree_cocker_db.model.entiy.User;
import by.step.semashko.pedigree_cocker_db.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult result, Model model){
        if (!user.getPassword().equals(user.getRepeatPassword())){
            return "registration";
        }
        if (result.hasErrors()){
            model.addAttribute("error",result);
        }
        if (!userService.save(user)){
            model.addAttribute("error","user exist");
            return "registration";
        }
        return "login";
    }
    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }
}
