package ru.sber.kapustin.homework3.part2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void addUntitledBookTest() {
        final var library = new Library();
        
        assertThrows(IllegalArgumentException.class, () -> library.addBook(new Book("Толстой", " ")));
    }

    @Test
    void addTwoIdenticalBooksTest() {
        final var library = new Library();
        assertTrue(library.addBook(new Book("Толстой", "Война и мир")));
        assertFalse(library.addBook(new Book("Толстой", "Война и мир")));
    }

    @Test
    void removeNotExistBookTest() {
        final var library = new Library();
        assertFalse(library.removeBook("Толстой", "Война и мир"));
    }

    @Test
    void removeBookTest() {
        final var library = new Library();
        library.addBook(new Book("Толстой", "Война и мир"));

        assertTrue(library.removeBook("Толстой", "Война и мир"));
        assertTrue(library.addBook(new Book("Толстой", "Война и мир")));
    }

    @Test
    void getNonExistBookTest() {
        final var library = new Library();
        assertNull(library.getBook("Толстой", "Война и мир"));
    }

    @Test
    void getBookTest() {
        final var library = new Library();
        library.addBook(new Book("Толстой", "Война и мир"));
        library.addBook(new Book("Толстой", "Анна Каренина"));

        assertEquals(new Book("Толстой", "Анна Каренина"), library.getBook("Толстой", "Анна Каренина"));
    }

    @Test
    void getBooksByNonExistAuthorTest() {
        final var library = new Library();
        assertEquals(new ArrayList<>(), library.getBooksByAuthor("Толстой"));
    }

    @Test
    void getBooksByAuthorTest() {
        final var library = new Library();
        library.addBook(new Book("Толстой", "Война и мир"));
        library.addBook(new Book("Толстой", "Анна Каренина"));

        final var expected = Arrays.asList(
                new Book("Толстой", "Анна Каренина"),
                new Book("Толстой", "Война и мир"));
        assertEquals(expected, library.getBooksByAuthor("Толстой"));
    }

    @Test
    void giveNewVisitorBookTest() {
        final var library = new Library();
        library.addBook(new Book("Толстой", "Война и мир"));

        final var visitor = new Visitor("Вася");

        assertTrue(library.giveVisitorBook(visitor, "Толстой", "Война и мир"));
        assertFalse(library.getBook("Толстой", "Война и мир").isNowInLibrary);

        assertEquals("1", visitor.id);
    }

    @Test
    void giveVisitorSecondBookTest() {
        final var library = new Library();
        library.addBook(new Book("Толстой", "Война и мир"));
        library.addBook(new Book("Толстой", "Анна Каренина"));

        final var visitor = new Visitor("Вася");
        library.giveVisitorBook(visitor, "Толстой", "Война и мир");

        assertFalse(library.giveVisitorBook(visitor, "Толстой", "Анна Каренина"));
    }

    @Test
    void getBookFromAnotherVisitorTest() {
        final var library = new Library();

        final var book = new Book("Толстой", "Война и мир");
        library.addBook(book);

        final var visitor = new Visitor("Вася");
        library.giveVisitorBook(visitor, "Толстой", "Война и мир");

        final var anotherVisitor = new Visitor("Петя");
        assertFalse(library.getBookFromVisitor(anotherVisitor, book));
    }

    @Test
    void getNonExistBookFromVisitorTest() {
        final var library = new Library();
        library.addBook(new Book("Толстой", "Война и мир"));

        final var visitor = new Visitor("Вася");
        library.giveVisitorBook(visitor, "Толстой", "Война и мир");

        assertFalse(library.getBookFromVisitor(visitor, new Book("Толстой", "Анна Каренина")));
    }

    @Test
    void getBookFromVisitorTest() {
        final var library = new Library();

        final var book = new Book("Толстой", "Война и мир");
        library.addBook(book);

        final var visitor = new Visitor("Вася");
        library.giveVisitorBook(visitor, "Толстой", "Война и мир");

        assertTrue(library.getBookFromVisitor(visitor, book));
        assertTrue(library.getBook("Толстой", "Война и мир").isNowInLibrary);

        assertNull(visitor.book);
    }
}
