package com.javaspring.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    //value here is the name of input in form (ref index.jsp)
    public String checkCode(@RequestParam(value="code") String code){
        if (code.equals("bushido"))
            return "redirect:/code";
        return "redirect:/Errors";
    }
    @RequestMapping("/code")
    public String code(){
        return "redirect:/code.html";
    }

    @RequestMapping("/Errors")
    public String Errors(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", "Your code needs revision");
        return "redirect:/";
    }
}
