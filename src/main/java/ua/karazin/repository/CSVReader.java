package ua.karazin.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.karazin.model.Language;
import ua.karazin.model.PartOfSpeech;
import ua.karazin.model.Translation;
import ua.karazin.model.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CSVReader {

    @Autowired private WordRepository repository;

    private static final Map<String, PartOfSpeech> posMap = new HashMap<>(8);

    public CSVReader() {
        posMap.put("[n]", PartOfSpeech.NOUN);
        posMap.put("[adj]", PartOfSpeech.ADJECTIVE);
        posMap.put("[adv]", PartOfSpeech.ADVERB);
        posMap.put("[v]", PartOfSpeech.VERB);
        posMap.put("[c]", PartOfSpeech.CONJUNCTION);
        posMap.put("[i]", PartOfSpeech.INTERJECTION);
        posMap.put("[pre]", PartOfSpeech.PREPOSITION);
        posMap.put("[pro]", PartOfSpeech.PRONOUN);
    }

    public void load(){
        File file = new File("src/main/resources/terms.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Word> terms = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Word word = parseTerm(line);
            terms.add(word);
        }

        repository.save(terms);

        sc.close();
    }

    private String[] parseRow(String row) {
        return row.split("\\t");
    }

    private Word parseTerm(String row) {
        Word term = new Word();
        term.setLanguage(Language.EN);
        term.setTranslations(new ArrayList<>());

        String[] items = parseRow(row);

        term.setValue(items[0]);

        if(items.length >= 3) {
            term.setTranscription(items[2]);
        }

        Pattern translationPattern = Pattern.compile("(\\d\\)\\s*)?([а-яА-Яієї\\s-+*./()]+)(\\[\\w+])?\\s*");
        Matcher matcher = translationPattern.matcher(items[1]);

        while (matcher.find()) {
            Word word = Word.translation(matcher.group(2).trim(), Language.UKR);
            Translation translation = new Translation();

            translation.setLeft(term);
            translation.setRight(word);

            String pos = matcher.group(3);
            if(pos != null && !pos.isEmpty()) {
                translation.setPartOfSpeech(posMap.get(pos.trim()));
            }

            word.setTranslations(Arrays.asList(translation));
            term.getTranslations().add(translation);
        }

        return term;
    }
}
