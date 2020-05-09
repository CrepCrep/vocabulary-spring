package com.crep.vocabulary;

import com.crep.vocabulary.infrastructure.VocabularyRepository;
import com.crep.vocabulary.messages.CreateVocabularyEntry;
import com.crep.vocabulary.model.VocabularyEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VocabularyController {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    @RequestMapping("/vocabulary/{titleUnit}")
    public List<VocabularyEntry> getVocabularyEntry(@PathVariable String titleUnit) {
        return vocabularyRepository.findByTitleUnitContainsIgnoreCase(titleUnit);
    }

    @RequestMapping(value = "/vocabulary", method = RequestMethod.POST)
    public VocabularyEntry addVocabularyEntry(@RequestBody CreateVocabularyEntry request) {
        var vocabularyEntry = new VocabularyEntry(request.getTitleUnit(), request.getExplains());
        vocabularyRepository.save(vocabularyEntry );
        return vocabularyEntry;
    }

}
