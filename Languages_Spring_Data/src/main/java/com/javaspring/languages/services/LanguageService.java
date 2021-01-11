package com.javaspring.languages.services;

import com.javaspring.languages.models.Language;
import com.javaspring.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    // adding the language repository as a dependency
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    // returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    // creates a language
    public Language createLang(Language x) {
        return languageRepository.save(x);
    }

    // retrieves a language by ID
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

    // update a language
    public Language updateLang(Long id, String name, String creator, Integer version) {
        Language updateLang = findLanguage(id);
        updateLang.setName(name);
        updateLang.setCreator(creator);
        updateLang.setVersion(version);
        return languageRepository.save(updateLang);
    }

    //Delete
    public void deleteLang(Long id) {
        languageRepository.deleteById(id);
    }

    public void updateLang(Language lang) {
        languageRepository.save(lang);
    }

}
