package ua.karazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.karazin.dto.TranslationDTO;
import ua.karazin.model.Word;
import ua.karazin.repository.WordRepository;

import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TranslationController {

    @Autowired private WordRepository repository;

    @GetMapping("/translate")
    @ResponseBody
    public TranslationDTO get2(@RequestParam("value") String value){
        return new TranslationDTO(repository.findByValueIgnoreCase(value));
    }

    @GetMapping("/translation")
    public String main(){
        return "main";
    }

    @GetMapping("/lookup")
    @ResponseBody
    public List<String> lookup(@RequestParam("term") String term){
        return repository.findAllByValueIgnoreCaseContains(term)
                         .stream()
                         .map(Word::getValue)
                         .collect(Collectors.toList());
    }
}