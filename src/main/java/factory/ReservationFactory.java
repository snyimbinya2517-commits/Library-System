/* ReservationFactory.java
   Reservation factory class
   
*/

//Author: Abulele Ntwanambi 218276400
//Date:
package factory;


import domain.Reservation;
import java.time.LocalDate;

//Author:
//Date: 16 March 2026

public class ReservationFactory
{
    public static Reservation createReservation(String reservationID, LocalDate date, String status) {

        if (reservationID == null || date == null || status == null) {
            return null;
        }
        return new Reservation.Builder()
                .setReservationID(reservationID)
                .setDate(date)
                .setStatus(status)
                .build();

    }
}


