package ua.karazin.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Word {

    @Id @GeneratedValue
    private long id;

    @Column(columnDefinition = "nvarchar(50)")
    private String value;

    @Column(columnDefinition = "nvarchar(50)")
    private String transcription;

    @Column(columnDefinition = "nvarchar(250)")
    private String definition;

    @Column(columnDefinition = "nvarchar(500)")
    private String videoPath;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToMany(cascade = CascadeType.ALL) private List<Translation> translations;

    //@OneToMany(cascade = CascadeType.ALL) private List<String> synonyms;
//=================================================================================
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

    public List<Translation> getTranslations()
    {
        return translations;
    }
    public void setTranslations(List<Translation> translations)
    {
        this.translations = translations;
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

//    public List<String> getSynonyms() {
//        return synonyms;
//    }
//    public void setSynonyms(List<String> synonyms) {
//        this.synonyms = synonyms;
//    }

    public static Word translation(String value, Language language) {
        Word translation = new Word();

        translation.setValue(value);
        translation.setLanguage(language);

        return translation;
    }
}
