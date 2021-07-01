package com.java.review.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.review.models.User;
import com.java.review.services.UserService;

@Controller
public class UsersController {
	private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String main(){
        return "redirect:/registration";
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()){
            return "registrationPage.jsp";
        } else {

           User newUser = userService.registerUser(user);
           session.setAttribute("userId",newUser.getId());
           return "redirect:/home";
        }
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
            //boolean isAuthenticated = userService.authenticateUser(email, password);
        if (userService.authenticateUser(email, password)) {
                User loggedUser = userService.findByEmail(email);
                session.setAttribute("userId", loggedUser.getId());
                return "redirect:/home";
            }
            else{
                model.addAttribute("error", "Invalid User. Please Register (or ELSE...)");
                return "loginPage.jsp";
        }
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        User loggedUser = userService.findUserById(userId);
        model.addAttribute("loggedUser", loggedUser);
        return "homePage.jsp";
        // get user from session, save them in the model and return the home page
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
        //return "loginPage.jsp";

        // invalidate session
        // redirect to login page
    }
}
