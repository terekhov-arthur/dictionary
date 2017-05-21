package ua.karazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.karazin.model.Language;
import ua.karazin.model.PartOfSpeech;
import ua.karazin.model.Word;
import ua.karazin.repository.WordRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/word")
public class AdminController {

    @Autowired private WordRepository repository;

    @PostMapping
    @ResponseBody
    public Word add(@ModelAttribute final Word word,
                      @RequestParam("definitionList") List<String> definitions,
                      @RequestParam("partOfSpeechList") List<String> partsOfSpeech) {

        final Language language = word.getLanguage() == Language.EN ? Language.UKR : Language.EN;

        List<Word> defs = convertDefinitions(definitions, partsOfSpeech);
        defs.forEach(w -> w.setLanguage(language));

        word.setDefinitions(defs);

        //todo: translation in two ways
        defs.forEach( d -> {
            Word loc = new Word();
            loc.setValue(word.getValue());
            loc.setLanguage(word.getLanguage());
            loc.setPartOfSpeech(d.getPartOfSpeech());
            d.setDefinitions(Arrays.asList(loc));
            repository.save(d.getDefinitions());
        });

        repository.save(word.getDefinitions());
        repository.save(word);

        return word;
    }

    private List<Word> convertDefinitions(List<String> names, List<String> partsOfSpeech) {
        List<Word> result = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            Word word = new Word();

            word.setValue(names.get(i));
            word.setPartOfSpeech(PartOfSpeech.valueOf(partsOfSpeech.get(i)));

            result.add(word);
        }

        return result;
    }

    @GetMapping
    public String get(Model model){
        model.addAttribute("languages", Language.values());
        model.addAttribute("partsOfSpeech", PartOfSpeech.values());
        return "add-word";
    }
}
