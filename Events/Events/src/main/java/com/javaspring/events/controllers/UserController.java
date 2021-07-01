package com.javaspring.events.controllers;

import com.javaspring.events.models.State;
import com.javaspring.events.models.User;
import com.javaspring.events.services.UserService;
import com.javaspring.events.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    //    private final UserService userService;
//    private final UserValidator userValidator;
//
//    public UserController(UserService userService, UserValidator userValidator) {
//        this.userService = userService;
//        this.userValidator = userValidator;
//    }
    @GetMapping("/")
    public String Index(@ModelAttribute("registration") User user, Model model, HttpSession session) {
        if(session.getAttribute("userId") != null)
            return "redirect:/events";
        model.addAttribute("states", State.States);
        return "registrationPage.jsp";
    }

    @PostMapping("/")
    public String Register(@Valid @ModelAttribute("registration") User user, BindingResult result, HttpSession session) {
        if(session.getAttribute("userId") != null)
            return "redirect:/events";
        userValidator.validate(user, result);
        if(result.hasErrors())
            return "registrationPage.jsp";
        User newUser = this.userService.registerUser(user);
        session.setAttribute("userId", newUser.getId());
        return "redirect:/events";
    }

    @PostMapping("/login")
    public String Login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirs) {
        if(this.userService.authenticateUser(email, password)) {
            User user = this.userService.findByEmail(email);
            session.setAttribute("userId", user.getId());
            return "redirect:/events";
        }
        redirs.addFlashAttribute("error", "Invalid Email/Password");
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if(session.getAttribute("userId") != null)
            session.invalidate();
        return "redirect:/";
    }
}
//    @RequestMapping("/")
//    public String main(){
//        return "redirect:/registration";
//    }
//
//    @RequestMapping("/registration")
//    public String registerForm(@ModelAttribute("user") User user) {
//        return "users/registrationPage.jsp";
//    }
//    @RequestMapping("/login")
//    public String login() {
//        return "loginPage.jsp";
//    }
//
//    @RequestMapping(value="/registration", method= RequestMethod.POST)
//    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
//        userValidator.validate(user, result);
//        if (result.hasErrors()){
//            return "users/registrationPage.jsp";
//        } else {
//            User newUser = userService.registerUser(user);
//            session.setAttribute("userId",newUser.getId());
//            return "redirect:/home";
//        }
//        // if result has errors, return the registration page (don't worry about validations just now)
//        // else, save the user in the database, save the user id in session, and redirect them to the /home route
//    }
//
//    @RequestMapping(value="/login", method=RequestMethod.POST)
//    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
//        //boolean isAuthenticated = userService.authenticateUser(email, password);
//        if (userService.authenticateUser(email, password)) {
//            User loggedUser = userService.findByEmail(email);
//            session.setAttribute("userId", loggedUser.getId());
//            return "redirect:/home";
//        }
//        else{
//            model.addAttribute("error", "Invalid User. Please Register (or ELSE...)");
//            return "loginPage.jsp";
//        }
//        // if the user is authenticated, save their user id in session
//        // else, add error messages and return the login page
//    }
//
//    @RequestMapping("/home")
//    public String home(HttpSession session, Model model) {
//        Long userId = (Long) session.getAttribute("userId");
//        User loggedUser = userService.findById(userId);
//        model.addAttribute("loggedUser", loggedUser);
//        return "/events/index.jsp";
//        // get user from session, save them in the model and return the home page
//    }
//    @RequestMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/login";
//        //return "loginPage.jsp";
//
//        // invalidate session
//        // redirect to login page
//    }
