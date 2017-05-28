package ua.karazin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Word {

    @Id @GeneratedValue
    private long id;

    @Column(columnDefinition = "nvarchar(50)")
    private String value;

    @Column(columnDefinition = "nvarchar(50)")
    private String transcription;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToMany(cascade = CascadeType.ALL) private List<Translation> translations;

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

    public static Word translation(String value, Language language) {
        Word translation = new Word();

        translation.setValue(value);
        translation.setLanguage(language);

        return translation;
    }
}
