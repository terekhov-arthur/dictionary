package ua.karazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.karazin.model.Word;
import ua.karazin.repository.WordRepository;

import java.util.List;

@RestController
public class TranslationController {

    @Autowired private WordRepository repository;

    @GetMapping("/translation/{value}")
    public List<Word> get(@PathVariable("value") String value){
        return repository.findAllByValueStartingWith(value);
    }
}
