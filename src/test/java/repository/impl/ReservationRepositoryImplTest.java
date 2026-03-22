package repository.impl;

import domain.Reservation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationRepositoryImplTest {

    @Test
    void testCreateReadUpdateDelete() {
        ReservationRepositoryImpl repository = new ReservationRepositoryImpl();

        Reservation reservation = new Reservation.Builder("R001", LocalDate.now(), "Available").setExpiryDate(LocalDate.now().plusDays(2)).build();
        repository.create(reservation);

        assertTrue(repository.read("R001").isPresent());

        Reservation updatedReservation = new Reservation.Builder("R001", LocalDate.now(), "Collected").setExpiryDate(LocalDate.now().plusDays(2)).build();
        repository.update(updatedReservation);
        assertTrue(repository.read("R001").isPresent());

        assertTrue(repository.delete("R001"));
        assertFalse(repository.read("R001").isPresent());
    }
}

