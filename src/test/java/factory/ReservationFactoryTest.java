package factory;


//Reservation Factory Test.
//Author:Abulele Ntwanambi 21827600
//Date:20/03/22026

import domain.Reservation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReservationFactoryTest {

    @Test
    void shouldcreateReservation(){


        Reservation reservation = ReservationFactory.createReservation("001", LocalDate.now(), "Available", LocalDate.now());

        assertEquals("001",reservation.getReservationID());
        assertEquals(LocalDate.now(),reservation.getDate());
        assertEquals("Available", reservation.getStatus());
        assertEquals(LocalDate.now(),reservation.getExpiryDate());

    }

    @Test
    void MissingReservationID(){
        assertThrows(IllegalArgumentException.class,() ->{
            new Reservation.Builder("",LocalDate.now(),"Available").build();

        });
    }
    @Test
    void shouldShowAvailableStatus() {
        assertDoesNotThrow(() -> {
            new Reservation.Builder("001",LocalDate.now(),"Available")

                    .setExpiryDate(LocalDate.now())
                    .build();

        });
    }

    @Test
    void failWhenStatusIsEmpty(){
        assertThrows(IllegalArgumentException.class,()->{
            new Reservation.Builder("001",LocalDate.now(),"")

                    .setExpiryDate(LocalDate.now())
                    .build();
        });


    }


    @Test
    void shouldShowCurrentDate(){
        LocalDate date = LocalDate.now();
        Reservation reservation = new Reservation.Builder("001",LocalDate.now(),"Available")

                .setExpiryDate(LocalDate.now())
                .build();

        assertEquals(date, reservation.getDate());
    }

    @Test
    void EmptyDate (){
        LocalDate date = LocalDate.now();
        Reservation reservation = new Reservation.Builder("001",LocalDate.now(),"Available")

                .setExpiryDate(LocalDate.now())
                .build();
    }

    @Test
    void shouldShowExpiryDate(){
        LocalDate expiryDate = LocalDate.now();
        Reservation reservation = new Reservation.Builder("001",LocalDate.now(),"Available")

                .setExpiryDate(LocalDate.now())
                .build();

        assertEquals(expiryDate, reservation.getExpiryDate());

    }
}
