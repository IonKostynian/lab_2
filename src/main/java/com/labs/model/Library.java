package com.labs.model;

import com.labs.enums.Genre;
import com.labs.enums.Language;

import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {
    @XmlElements({
            @XmlElement(name = "vocabulary", type = Vocabulary.class),
            @XmlElement(name = "textBook", type = TextBook.class)
    })
    private List<Book> books;

    public Library () {
        books = new LinkedList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    /**
     * Method for comparing of Library instance with another instance
     * @param o another instance for comparing
     * @return result of comparing Library instance with another instance
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books);
    }

    /**
     * Method for getting hash code of the instance of Library
     * @return hash code of instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    /**
     * Method for converting the instance of Library to String format
     * @return string format of the instance of Library
     */
    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }

    public boolean addBook(Book book){
        return this.books.add(book);
    }

    public List<String> getAllBookNames() {
        List<String> res = new LinkedList<>();

        for (Book book : books) {
            res.add(book.getName());
        }

        return res;
    }

    public List<String> getAllBookNamesUsingStream() {
        return books.stream()
                .map(Book::getName)
                .collect(Collectors.toList());
    }

    public List<Vocabulary> getVocabulariesByLanguageFrom(Language languageFrom){
        List<Vocabulary> res = new LinkedList<>();

        for (Book book : books) {
            if (book.getClass().equals(Vocabulary.class)) {
                Vocabulary vocabulary = (Vocabulary) book;

                if (vocabulary.getLanguageFrom().equals(languageFrom)) {
                    res.add(vocabulary);
                }
            }
        }

        return res;
    }

    public List<Vocabulary> getVocabulariesByLanguageFromUsingStream(Language languageFrom){
        return books.stream()
                .filter(book -> book.getClass().equals(Vocabulary.class))
                .map(book -> (Vocabulary) book)
                .filter(vocabulary -> vocabulary.getLanguageFrom().equals(languageFrom))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<TextBook> getTextBooksByGenre(Genre genre){
        List<TextBook> res = new LinkedList<>();

        for (Book book : books) {
            if (book.getClass().equals(TextBook.class)) {
                TextBook textBook = (TextBook) book;

                if (textBook.getGenre().equals(genre)) {
                    res.add(textBook);
                }
            }
        }

        return res;
    }

    public List<TextBook> getTextBooksByGenreUsingStreams(Genre genre){
        return books.stream()
                .filter(book -> book.getClass().equals(TextBook.class))
                .map(book -> (TextBook) book)
                .filter(textBook -> textBook.getGenre().equals(genre))
                .sorted()
                .collect(Collectors.toList());
    }
}
