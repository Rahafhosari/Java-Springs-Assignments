package com.javaspring.license.controllers;

import com.javaspring.license.models.License;
import com.javaspring.license.models.Person;
import com.javaspring.license.services.LicensesService;
import com.javaspring.license.services.PersonsService;
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
public class DriverController {

    private final PersonsService personsService;
    private final LicensesService licensesService;

    public DriverController(LicensesService licensesService, PersonsService personsService) {
        this.licensesService = licensesService;
        this.personsService = personsService;
    }

    @RequestMapping("/")
    public String main(){
        return "redirect:/persons/new";
    }

    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "person.jsp";
    }

    @RequestMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license,Model model) {
        List<Person> persons  = personsService.allPersons();
        model.addAttribute("persons",persons);
        return "license.jsp";
    }

    @RequestMapping("/persons/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Person person = personsService.findPerson(id);
        model.addAttribute("person", person);
        return "info.jsp";
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "person.jsp";
        } else {
            personsService.createPerson(person);
            return "redirect:/licenses/new";
        }
    }

    @RequestMapping(value = "/licenses", method = RequestMethod.POST)
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "license.jsp";
        } else {
            License newLicence = licensesService.createLicense(license);
            return "redirect:/persons/"+newLicence.getPerson().getId();
        }
    }
}

//    @RequestMapping("/")
//    public String main(){
//        return "redirect:/drivers";
//    }
//    @RequestMapping("/drivers")
//    public String index(Model model) {
//        List<Person> persons = personsService.allPersons();
//        List<License> licenses = licensesService.allLicenses();
//        model.addAttribute("persons", person);
//        model.addAttribute("licences", license);
//        return "index.jsp";
//    }