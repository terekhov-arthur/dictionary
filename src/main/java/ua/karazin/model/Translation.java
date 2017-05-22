package ua.karazin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Translation
{
    @Id @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)   private Word left;
    @OneToOne(cascade = CascadeType.ALL)   private Word right;
    @Enumerated(EnumType.STRING) private PartOfSpeech partOfSpeech;

    public long getId()
    {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Word getLeft()
    {
        return left;
    }
    public void setLeft(Word left)
    {
        this.left = left;
    }

    public Word getRight()
    {
        return right;
    }
    public void setRight(Word right)
    {
        this.right = right;
    }

    public PartOfSpeech getPartOfSpeech()
    {
        return partOfSpeech;
    }
    public void setPartOfSpeech(PartOfSpeech partOfSpeech)
    {
        this.partOfSpeech = partOfSpeech;
    }
}
