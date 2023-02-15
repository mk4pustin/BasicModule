package ru.sber.kapustin.homework3.part2;

import java.util.ArrayList;
import java.util.List;

public class Book {
    public final String author;
    public final String title;

    boolean isNowInLibrary;

    List<Integer> rates;

    public Book(String author, String title) {
        if (Utils.isStringEmpty(author) || Utils.isStringEmpty(title))
            throw new IllegalArgumentException("The title and author of the book must not be empty.");

        this.author = author;
        this.title = title;

        rates = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final var book = (Book) o;
        return author.equals(book.author) && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        final var prime = 31;
        return author.hashCode() * prime + title.hashCode();
    }

    @Override
    public String toString() {
        return "Author: " + author + ", Title: " + title;
    }
}
