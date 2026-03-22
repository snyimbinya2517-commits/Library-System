package repository.impl;

import domain.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryImplTest {

    @Test
    void testCreateReadUpdateDelete() {
        BookRepositoryImpl repository = new BookRepositoryImpl();

        Book book = new Book.Builder("9780134685991", "Effective Java").build();
        repository.create(book);

        assertTrue(repository.read("9780134685991").isPresent());

        Book updatedBook = new Book.Builder("9780134685991", "Effective Java 3rd Edition").build();
        repository.update(updatedBook);
        assertTrue(repository.read("9780134685991").isPresent());

        assertTrue(repository.delete("9780134685991"));
        assertFalse(repository.read("9780134685991").isPresent());
    }
}

