package com.crep.vocabulary.infrastructure;

import com.crep.vocabulary.model.VocabularyEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabularyRepository extends JpaRepository<VocabularyEntry, Integer> {
    List<VocabularyEntry> findByTitleUnitContainsIgnoreCase(String titleUnit);
}
