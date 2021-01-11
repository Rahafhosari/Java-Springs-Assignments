package com.javaspring.languages.controllers;

import com.javaspring.languages.models.Language;
import com.javaspring.languages.services.LanguageService;
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
public class LanguagesController {
    private final LanguageService languageService;

    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/")
    public String main() {
        return "redirect:/languages";
    }

    @RequestMapping("/languages")
    public String index(Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }

    //Show
    @RequestMapping(value = "/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Language lang = languageService.findLanguage(id);
        model.addAttribute("lang", lang);
        return "/languages/show.jsp";
    }

    //Create
    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language) {
        return "/languages/new.jsp";
    }

    @RequestMapping(value = "/languages", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/new.jsp";
        } else {
            languageService.createLang(language);
            return "redirect:/languages";
        }
    }

    //Edit
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }

    //Update
    @RequestMapping(value = "/languages/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languageService.updateLang(language);
            return "redirect:/languages";
        }
    }

    //Delete
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLang(id);
        return "redirect:/languages";
    }
}
