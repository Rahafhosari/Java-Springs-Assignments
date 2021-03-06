package com.javaspring.counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CounterController {
    @RequestMapping("/")
    public String index(HttpSession session){
        if (session.isNew()){
            session.setAttribute("count",0);
        }
        else {
            Integer count = (Integer) session.getAttribute("count");
            count += 1;
            session.setAttribute("count", count);
        }
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counter(){
        return "counter.jsp";
    }
}
