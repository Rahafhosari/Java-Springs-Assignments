import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class GoldController {
    @RequestMapping("/")
    public String index(HttpSession session){
        if (session.isNew()) { //is equal to null
            session.setAttribute("gold", 0);
            session.setAttribute("activity", "");
        }
        return "index.jsp";
    }
    @RequestMapping("/gold")
    public String findGold (HttpSession session, @RequestParam (value = "whichForm") String whichForm,  Model date) {
        session.setAttribute("whichForm", whichForm);
        //String whichForm =(String) session.getAttribute("whichForm")
        int gold = (Integer) session.getAttribute("gold");
        String activities = (String) session.getAttribute("activity");
        //date
        //String currentDate = new SimpleDateFormat("MMMM dd yyyy, hh:mm a").format(new Date());
        //date.addAttribute("displayDate", currentDate);
        Date currentDate = new Date();

        //random gold
        Random randGold = new Random();

        if (whichForm == "farm") {
            int earned = randGold.nextInt(11) + 10;
            int sumGold = earned + gold;
            session.setAttribute("gold", sumGold);
            String activity = activities + "You entered a farm and earned " + earned + " gold." + "(" + currentDate + ")</br>";
            session.setAttribute("activities", activity);
        }
        if (whichForm == "cave") {
            int earned = randGold.nextInt(6) + 5;
            int sumGold = earned + gold;
            session.setAttribute("gold", sumGold);
            String activity = activities + "You entered a cave and earned " + earned + " gold." + "(" + currentDate + ")</br>";
            session.setAttribute("activities", activity);
        }
        if (whichForm == "house") {
            int earned = randGold.nextInt(4) + 2;
            int sumGold = earned + gold;
            session.setAttribute("gold", sumGold);
            String activity = activities + "You entered a house and earned " + earned + " gold." + "(" + currentDate + ")</br>";
            session.setAttribute("activities", activity);
        }
        if (whichForm == "casino") {
            int earned = randGold.nextInt(50) * (randGold.nextBoolean() ? -1 : 1);
            if (earned > 0) {
                int sumGold = earned + gold;
                session.setAttribute("gold", sumGold);
                String activity = activities + "You entered a casino and earned " + earned + " gold." + "(" + currentDate + ")</br>";
                session.setAttribute("activities", activity);
            } else {
                int sumGold = earned - gold;
                session.setAttribute("gold", sumGold);
                String activity = activities + "You entered a casino and lost " + earned + " gold... Opss ..." + "(" + currentDate + ")</br";
                session.setAttribute("activities", activity);
            }
    }
        return "redirect:/";
    }
}

