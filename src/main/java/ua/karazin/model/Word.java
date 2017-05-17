package ua.karazin.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Word {

    @Id @GeneratedValue
    private long id;
    private String value;
    private String transcription;

    @Enumerated(EnumType.STRING)
    private PartOfSpeech partOfSpeech;

    @Enumerated(EnumType.STRING)
    private Language language;

    @OneToMany  private List<Word> synonyms;
    @ManyToMany private List<Word> definitions;

    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }

    public String getValue()
    {
        return value;
    }
    public void setValue(String value)
    {
        this.value = value;
    }

    public PartOfSpeech getPartOfSpeech()
    {
        return partOfSpeech;
    }
    public void setPartOfSpeech(PartOfSpeech partOfSpeech)
    {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Word> getDefinitions()
    {
        return definitions;
    }
    public void setDefinitions(List<Word> definitions)
    {
        this.definitions = definitions;
    }

    public List<Word> getSynonyms() {
        return synonyms;
    }
    public void setSynonyms(List<Word> synonyms) {
        this.synonyms = synonyms;
    }

    public Language getLanguage()
    {
        return language;
    }
    public void setLanguage(Language language)
    {
        this.language = language;
    }

    public String getTranscription()
    {
        return transcription;
    }
    public void setTranscription(String transcription)
    {
        this.transcription = transcription;
    }
}
