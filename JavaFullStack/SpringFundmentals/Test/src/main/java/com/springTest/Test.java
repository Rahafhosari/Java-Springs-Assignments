package com.springTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	  @RequestMapping("/")
	    public String index(Model model) {
	        model.addAttribute("dojoName", "Burbank");
	        return "index.jsp";
	    }
}
