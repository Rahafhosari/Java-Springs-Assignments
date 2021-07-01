package com.java.courses.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.courses.models.Course;
import com.java.courses.models.User;
import com.java.courses.services.CourseService;
import com.java.courses.services.UserService;

@Controller
public class UsersController {
	private final UserService userService;
	private final CourseService courseService;

    public UsersController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
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
        List <Course> course = courseService.allCourses();
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("courses", course);
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
    
    @RequestMapping("/createcourse")
	public String createCourse(@ModelAttribute("course") Course course,Model model,HttpSession session) {
    	model.addAttribute("courses", courseService.allCourses());
		return "create.jsp";
	}
	
	 @RequestMapping(value = "/courses",method = RequestMethod.POST)
	    public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result,Model model) {
	        if(result.hasErrors()) {
	            model.addAttribute("courses", courseService.allCourses());
	            return "create.jsp";
	        } else {
	            this.courseService.createCourse(course);
	            return "redirect:/home";
	        }
	    }

//	  @RequestMapping("/courses/{id}"
//	    public String showrecipe(@PathVariable("id") Long id, Model model, HttpSession session, @ModelAttribute("comm") Comment comment) {
//	        Long userId = (Long) session.getAttribute("userId");
//	        model.addAttribute("recipe", this.irecipeService.findByIdR(id));
//	        Recipe recipe1=this.irecipeService.findByIdR(id);
//	        List <Comment> comments=recipe1.getComment();
//	        User u = irecipeService.findUserById(userId);
//	        model.addAttribute("user", u);
//	        model.addAttribute("comments", comments);
//	        return "showRecipe.jsp";
//	    }

}
