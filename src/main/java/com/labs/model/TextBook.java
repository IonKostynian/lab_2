package com.labs.model;

import com.labs.enums.Genre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.Year;
import java.util.Comparator;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class TextBook extends Book implements Comparator<TextBook>, Comparable<TextBook>{
    @XmlElement
    public Genre genre;

    public TextBook () {

        setYearOfPublication(Year.now());

    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return super.getAuthor();
    }

    public void setAuthor(String author) {
        super.setAuthor(author);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getPublication() {
        return super.getPublication();
    }

    public void setPublication(String publication) {
        super.setPublication(publication);
    }

    public int getYearOfPublication() {
        return super.getYearOfPublication();
    }

    public void setYearOfPublication(Year yearOfPublication) {
        super.setYearOfPublication(yearOfPublication);
    }

    /**
     * Method for comparing of TextBook instance with another instance
     * @param o another instance for comparing
     * @return result of comparing TextBook instance with another instance
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextBook textBook = (TextBook) o;
        return Objects.equals(getAuthor(),textBook.getAuthor())
                && Objects.equals(getName(),textBook.getName())
                && Objects.equals(getPublication(),textBook.getPublication())
                && Objects.equals(getYearOfPublication(),textBook.getYearOfPublication())
                && genre == textBook.genre;
    }

    /**
     * Method for getting hash code of the instance of TextBook
     * @return hash code of instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getName(), getPublication(), getYearOfPublication(), genre);
    }

    /**
     * Method for converting the instance of TextBook to String format
     * @return string format of the instance of TextBook
     */
    @Override
    public String toString() {
        return "TextBook{" +
                "author=" + getAuthor() +
                ", name=" + getName() +
                ", publication=" + getPublication() +
                ", yearOfPublication=" + getYearOfPublication() +
                ", genre=" + genre +
                "}";
    }

    @Override
    public int compareTo(TextBook o) {
        int flag = this.genre.toString().compareTo(o.genre.toString());
        if (flag != 0) return flag;

        flag = this.getName().compareTo(o.getName());
        if (flag != 0) return flag;

        flag = this.getAuthor().compareTo(o.getAuthor());
        if (flag != 0) return flag;

        flag = this.getPublication().compareTo(o.getPublication());
        if (flag != 0) return flag;

        return this.getYearOfPublication()-o.getYearOfPublication();
    }

    @Override
    public int compare(TextBook o1, TextBook o2) {
        return o1.compareTo(o2);
    }

    /**
     * Realisation of the builder pattern for class TextBook
     */
    public static class TextBookBuilder {
        private TextBook textBook = new TextBook();

        public TextBookBuilder setName(String name) {
            textBook.setName(name);
            return this;
        }

        public TextBookBuilder setAuthor(String author) {
            textBook.setAuthor(author);
            return this;
        }

        public TextBookBuilder setPublication (String publication) {
            textBook.setPublication(publication);
            return this;
        }

        public TextBookBuilder setYearOfPublication(int yearOfPublication) {
            textBook.setYearOfPublication(Year.of(yearOfPublication));
            return this;
        }

        public TextBookBuilder setGenre(Genre genre) {
            textBook.setGenre(genre);
            return this;
        }

        /**
         * @return instance of TextBook
         */
        public TextBook build() {
            return textBook;
        }
    }
}