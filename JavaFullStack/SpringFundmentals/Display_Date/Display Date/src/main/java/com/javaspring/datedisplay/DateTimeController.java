package com.javaspring.datedisplay;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DateTimeController {
    @RequestMapping("/")
        public String index(){
        return "index.jsp";
    }
    @RequestMapping("/date")
        public String date(Model date){
        String currentDate= new SimpleDateFormat("EEEE,dd MMMM,yyyy").format(new Date());
        date.addAttribute("displayDate",currentDate);
        return "date.jsp";
    }
    @RequestMapping("/time")
        public String time(Model time){
            String currentTime= new SimpleDateFormat("h:mm:ss a").format(new Date());
            time.addAttribute("displayTime",currentTime);
        return "time.jsp";
    }

}
