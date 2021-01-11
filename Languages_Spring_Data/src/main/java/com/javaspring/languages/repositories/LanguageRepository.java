package com.javaspring.languages.repositories;

import com.javaspring.languages.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findAll();
//    List<Language> findByDescriptionContaining(String search);
//    Long countByTitleContaining(String search);
//    Long deleteByTitleStartingWith(String search);
}
