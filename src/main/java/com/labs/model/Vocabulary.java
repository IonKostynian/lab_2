package com.labs.model;

import com.labs.enums.Language;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.time.Year;
import java.util.Comparator;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Vocabulary extends Book implements Comparator<Vocabulary>, Comparable<Vocabulary> {
    private Language languageFrom;
    private Language languageTo;

    /**
     * Default constructor for Vocabulary class
     */
    public Vocabulary () {

        setYearOfPublication(Year.now());

    }

    public Language getLanguageFrom() {
        return languageFrom;
    }

    public void setLanguageFrom(Language languageFrom) {
        this.languageFrom = languageFrom;
    }

    public Language getLanguageTo() {
        return languageTo;
    }

    public void setLanguageTo(Language languageTo) {
        this.languageTo = languageTo;
    }

    @Override
    public int compare(Vocabulary o1, Vocabulary o2) {
        int flag = o1.languageFrom.toString().compareTo(o2.languageFrom.toString());
        if (flag != 0) return flag;

        flag = o1.languageTo.toString().compareTo(o2.languageTo.toString());
        if (flag != 0) return flag;

        flag = o1.getName().compareTo(o2.getName());
        if (flag != 0) return flag;

        flag = o1.getAuthor().compareTo(o2.getAuthor());
        if (flag != 0) return flag;

        flag = o1.getPublication().compareTo(o2.getPublication());
        if (flag != 0) return flag;

        return o1.getYearOfPublication()-o2.getYearOfPublication();
    }


    @Override
    public int compareTo(Vocabulary o) {
        return compare(this, o);
    }

    /**
     * Method for comparing of Vocabulary instance with another instance
     * @param o another instance for comparing
     * @return result of comparing Vocabulary instance with another instance
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vocabulary that = (Vocabulary) o;
        return Objects.equals(getAuthor(),that.getAuthor())
                && Objects.equals(getName(),that.getName())
                && Objects.equals(getPublication(),that.getPublication())
                && Objects.equals(getYearOfPublication(),that.getYearOfPublication())
                && languageFrom == that.languageFrom
                && languageTo == that.languageTo;
    }

    /**
     * Method for getting hash code of the instance of Vocabulary
     * @return hash code of instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getName(), getPublication(), getYearOfPublication(), languageFrom, languageTo);
    }

    /**
     * Method for converting the instance of Vocabulary to String format
     * @return string format of the instance of Vocabulary
     */
    @Override
    public String toString() {
        return "Vocabulary{" +
                "author=" + getAuthor() +
                ", name=" + getName() +
                ", publication=" + getPublication() +
                ", yearOfPublication=" + getYearOfPublication() +
                ", languageFrom=" + languageFrom +
                ", languageTo=" + languageTo +
                "}";
    }

    /**
     * Realisation of the builder pattern for class Vocabulary
     */
    public static class VocabularyBuilder {
        private Vocabulary vocabulary = new Vocabulary();

        public VocabularyBuilder setName(String name) {
            vocabulary.setName(name);
            return this;
        }

        public VocabularyBuilder setAuthor(String author) {
            vocabulary.setAuthor(author);
            return this;
        }

        public VocabularyBuilder setPublication (String publication) {
            vocabulary.setPublication(publication);
            return this;
        }

        public VocabularyBuilder setYearOfPublication(int yearOfPublication) {
            vocabulary.setYearOfPublication(Year.of(yearOfPublication));
            return this;
        }

        public VocabularyBuilder setLanguageFrom (Language languageFrom) {
            vocabulary.setLanguageFrom(languageFrom);
            return this;
        }

        public VocabularyBuilder setLanguageTo (Language languageTo) {
            vocabulary.setLanguageTo(languageTo);
            return this;
        }

        /**
         * @return instance of TextBook
         */
        public Vocabulary build() {
            return vocabulary;
        }
    }
}
