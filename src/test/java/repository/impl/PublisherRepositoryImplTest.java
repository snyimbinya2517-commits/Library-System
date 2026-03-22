/*
Author:
Date: 
*/
package repository.impl;

import domain.Publisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublisherRepositoryImplTest {

    @Test
    void testCreateReadUpdateDelete() {
        PublisherRepositoryImpl repository = new PublisherRepositoryImpl();

        Publisher publisher = new Publisher.Builder("P001", "Pearson").setPublisherAddress("Address").setPublisherEmail("pearson@email.com").setPublisherPhone("0111111111").build();
        repository.create(publisher);

        assertTrue(repository.read("P001").isPresent());

        Publisher updatedPublisher = new Publisher.Builder("P001", "Pearson Updated").setPublisherAddress("Address").setPublisherEmail("pearson@email.com").setPublisherPhone("0111111111").build();
        repository.update(updatedPublisher);
        assertTrue(repository.read("P001").isPresent());

        assertTrue(repository.delete("P001"));
        assertFalse(repository.read("P001").isPresent());
    }
}

