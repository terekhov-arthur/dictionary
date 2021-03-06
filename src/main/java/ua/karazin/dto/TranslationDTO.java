package ua.karazin.dto;

import javafx.util.Pair;
import ua.karazin.model.PartOfSpeech;
import ua.karazin.model.Translation;
import ua.karazin.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TranslationDTO {
    private long wordId;
    private String word;
    private String transcription;
    private String definition;
    private String videoPath;
    private String language;
    private List<Pair<String, PartOfSpeech>> translations;

    public TranslationDTO(Word word) {
        translations = new ArrayList<>();

        wordId = word.getId();
        this.word = word.getValue();
        transcription = word.getTranscription();
        definition = word.getDefinition();
        videoPath = word.getVideoPath();
        language = word.getLanguage().toString();

        for (Translation translation : word.getTranslations()) {
            Word translationWord =
                    translation.getLeft().getValue().equals(word.getValue()) ? translation.getRight() : translation.getLeft();
            translations.add(new Pair<>(translationWord.getValue(), translation.getPartOfSpeech()));
        }

        translations.sort((t1, t2) -> {

            PartOfSpeech left = t1.getValue();
            PartOfSpeech right = t2.getValue();

            if(Objects.equals(left, right)) {
                return 0;
            } else if(left != null && right != null) {
                left.compareTo(right);
            }

            return 1;
        });
    }

    public long getWordId()
    {
        return wordId;
    }
    public void setWordId(long wordId)
    {
        this.wordId = wordId;
    }

    public String getWord()
    {
        return word;
    }
    public void setWord(String word)
    {
        this.word = word;
    }

    public List<Pair<String, PartOfSpeech>> getTranslations()
    {
        return translations;
    }
    public void setTranslations(List<Pair<String, PartOfSpeech>> translations)
    {
        this.translations = translations;
    }

    public String getTranscription()
    {
        return transcription;
    }
    public void setTranscription(String transcription)
    {
        this.transcription = transcription;
    }

    public String getDefinition() {
        return definition;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getVideoPath() {
        return videoPath;
    }
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
