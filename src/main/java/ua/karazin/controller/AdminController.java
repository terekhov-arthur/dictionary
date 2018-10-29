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
import ua.karazin.dto.TranslationDTO;
import ua.karazin.model.Language;
import ua.karazin.model.PartOfSpeech;
import ua.karazin.model.Translation;
import ua.karazin.model.Word;
import ua.karazin.repository.CSVReader;
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
    public TranslationDTO add(@ModelAttribute final Word word,
                      @RequestParam("definitionList") List<String> definitions,
                      @RequestParam("partOfSpeechList") List<String> partsOfSpeech) {

        List<Translation> translations = convertTranslations(word, definitions, partsOfSpeech);
        word.setTranslations(translations);

        repository.save(word);

        return new TranslationDTO(word);
    }

    @GetMapping
    public String get(Model model){
        model.addAttribute("languages", Language.values());
        model.addAttribute("partsOfSpeech", PartOfSpeech.values());
        return "add-word";
    }

    private List<Translation> convertTranslations(Word word, List<String> translations, List<String> partsOfSpeech) {
        final Language language = word.getLanguage() == Language.EN ? Language.UKR : Language.EN;
        final List<Translation> result = new ArrayList<>();

        for (int i = 0; i < translations.size(); i++) {
            Translation translation = new Translation();
            Word translationWord = Word.translation(translations.get(i), language);

            translation.setPartOfSpeech(PartOfSpeech.valueOf(partsOfSpeech.get(i)));
            translation.setLeft(word);
            translation.setRight(translationWord);
            translationWord.setTranslations(Arrays.asList(translation));

            result.add(translation);
        }

        return result;
    }
}
