package ru.sber.kapustin.homework3.part2;

import java.util.*;

public class Library {
    private final Set<Book> libraryBooks;
    private final Set<Visitor> visitors;

    private static final int MAX_RATE = 5;

    public Library() {
        libraryBooks = new HashSet<>();
        visitors = new HashSet<>();
    }

    public boolean addBook(Book book) {
        if (libraryBooks.add(book)) book.isNowInLibrary = true;

        return book.isNowInLibrary;
    }

    public boolean removeBook(String author, String title) {
        final var libraryBook = getBook(author, title);

        if (libraryBook != null && libraryBook.isNowInLibrary)
            return libraryBooks.remove(libraryBook);

        return false;
    }

    public Book getBook(String author, String title) {
        if (Utils.isStringEmpty(author) || Utils.isStringEmpty(title)) return null;

        final var libraryBook = libraryBooks.stream()
                .filter(book -> book.equals(new Book(author, title)))
                .toList();

        return libraryBook.size() == 0 ? null : libraryBook.get(0);
    }

    public List<Book> getBooksByAuthor(String author) {
        if (Utils.isStringEmpty(author)) return new ArrayList<>();

        return libraryBooks.stream()
                .filter(book -> author.equals(book.author))
                .toList();
    }

    public boolean giveVisitorBook(Visitor visitor, String author, String title) {
        final var libraryBook = getBook(author, title);
        if (libraryBook == null || !libraryBook.isNowInLibrary) return false;

        if (visitors.add(visitor))
            visitor.id = String.valueOf(visitors.size());

        if (visitor.book == null) {
            libraryBook.isNowInLibrary = false;
            visitor.book = libraryBook;
        }

        return !libraryBook.isNowInLibrary;
    }

    public boolean getBookFromVisitor(Visitor visitor, Book book) {
        final var libBook = getBook(book.author, book.title);
        if (visitor == null || visitor.book == null || libBook == null || libBook != book) return false;

        visitor.book = null;
        libBook.isNowInLibrary = true;

        return true;
    }

    public boolean getBookFromVisitor(Visitor visitor, Book book, int rating) {
        if (rating < 0 || rating > MAX_RATE)
            throw new IllegalArgumentException("The rating must be between 0 and 5.");

        if (getBookFromVisitor(visitor, book)) book.rates.add(rating);
        return book.isNowInLibrary;
    }

    public double getBookRating(String author, String title) {
        final var libBook = getBook(author, title);
        if (libBook == null) return 0;

        final var ratesCount = libBook.rates.size();
        return ratesCount == 0? 0 : (double) libBook.rates.stream()
                .mapToInt(Integer::intValue)
                .sum() / ratesCount;
    }
}
