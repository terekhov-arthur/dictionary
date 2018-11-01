package ua.karazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.karazin.dto.TranslationDTO;
import ua.karazin.model.Word;
import ua.karazin.repository.WordRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TranslationController {

    @Autowired private WordRepository repository;

    @GetMapping("/translate")
    @ResponseBody
    public TranslationDTO get2(@RequestParam("value") String value){
        return new TranslationDTO(repository.findByValueIgnoreCase(value.trim()));
    }

    @GetMapping("/translation")
    public String main(){
        return "main";
    }

    @GetMapping("/lookup")
    @ResponseBody
    public List<String> lookup(@RequestParam("term") String term){
        return repository.findAllByValueIgnoreCaseContainsOrderByValue(term)
                         .stream()
                         .map(Word::getValue)
                         .collect(Collectors.toList());
    }

    @GetMapping("/video/{path}")
    @ResponseBody public FileSystemResource getPreview3(@PathVariable("path") String path, HttpServletResponse response) {
        return new FileSystemResource(path);
    }
}