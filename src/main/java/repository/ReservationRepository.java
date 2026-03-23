/* ReservationRepository.java
   Reservation repository interface
   Author: 
   Date: 
*/
package repository;

import domain.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.*;
import java.util.Optional;

public interface ReservationRepository extends IRepository<Reservation, String> {
    List<Reservation> findAllByDate(LocalDate date);
    List<Reservation> findByExpiryDate(LocalDate expiryDate);

}
