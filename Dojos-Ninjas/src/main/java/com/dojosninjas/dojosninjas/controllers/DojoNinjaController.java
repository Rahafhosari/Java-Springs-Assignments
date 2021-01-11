package com.dojosninjas.dojosninjas.controllers;

import com.dojosninjas.dojosninjas.models.Dojo;
import com.dojosninjas.dojosninjas.models.Ninja;
import com.dojosninjas.dojosninjas.services.DojoServices;
import com.dojosninjas.dojosninjas.services.NinjaServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DojoNinjaController {
    private final DojoServices dojoServices;
    private final NinjaServices ninjaServices;

    public DojoNinjaController(DojoServices dojoServices, NinjaServices ninjaServices) {
        this.dojoServices = dojoServices;
        this.ninjaServices = ninjaServices;
    }

    @RequestMapping("/")
    public String main(){
        return "redirect:/dojos/new";
    }

    @RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo){
        return "dojos/dojos.jsp";
    }

    @RequestMapping(value = "/newDojo", method = RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "dojos/dojos.jsp";
        } else {
            dojoServices.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
    }
    @RequestMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
        List<Dojo> dojo =dojoServices.allDojos();
        model.addAttribute("dojo",dojo);
        return "ninjas/ninjas.jsp";
    }
    @RequestMapping(value = "/newNinja", method = RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "ninjas/ninjas.jsp";
        } else {
           Ninja newNinja = ninjaServices.createNinja(ninja);
            return "redirect:/dojos/"+newNinja.getDojo().getId();
        }
    }
    @RequestMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Dojo dojo = dojoServices.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "dojos/show.jsp";
    }
}
//    @RequestMapping("/dojos/new")
//    public String newDojo(@ModelAttribute("dojos") Dojo dojo,Model model){
//        List<Dojo> dojos = dojoServices.allDojos();
//        model.addAttribute("dojo",dojos);
//        return "dojos/dojos.jsp";
//    }
//
//    @RequestMapping(value = "/newDojo", method = RequestMethod.POST)
//    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
//        if (result.hasErrors()) {
//            return "dojos/dojos.jsp";
//        } else {
//            dojoServices.createDojo(dojo);
//            return "redirect:/dojos/new";
//        }
//    }