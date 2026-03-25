package repository.impl;
// Author Abulele Ntwanambi 218276400

import domain.Reservation;
import repository.ReservationRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReservationRepositoryImpl implements ReservationRepository {

    private final Map<String, Reservation> storage = new HashMap<>();

    @Override
    public Reservation create(Reservation entity) {
        storage.put(entity.getReservationID(), entity);
        return entity;
    }

    @Override
    public Optional<Reservation> read(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Reservation update(Reservation entity) {
        if (storage.containsKey(entity.getReservationID())) {
            storage.put(entity.getReservationID(), entity);
            return entity;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id) != null;
    }

    @Override
    public Collection<Reservation> getAll() {
        return storage.values();
    }

    @Override
    public List<Reservation> findAllByDate(LocalDate date) {
        return storage.values()
                .stream()
                .filter(r -> r.getDate().equals(date))
                .toList();
    }

    @Override
    public List<Reservation> findByExpiryDate(LocalDate expiryDate) {
        return storage.values()
                .stream()
                .filter(r -> r.getExpiryDate().equals(expiryDate))
                .toList();
    }
}
