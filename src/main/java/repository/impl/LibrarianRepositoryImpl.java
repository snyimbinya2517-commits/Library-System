/*Author:
Date: 
*/
package repository.impl;

import domain.Librarian;
import domain.Reservation;
import repository.LibrarianRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LibrarianRepositoryImpl implements LibrarianRepository {

	private final Map<String, Librarian> storage = new HashMap<>();

    private static ReservationRepositoryImpl repository = null;



    public static ReservationRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ReservationRepositoryImpl();

        }
        return repository;

    }

	@Override
	public Librarian create(Librarian entity) {
		storage.put(entity.getStaffId(), entity);
		return entity;
	}

    @Override
    public Librarian save(Librarian entity) {
        return null;
    }

    @Override
	public Optional<Librarian> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

    @Override
    public Optional<Librarian> findById(String s) {
        return Optional.empty();
    }

    @Override
	public Librarian update(Librarian entity) {
		storage.put(entity.getStaffId(), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}
}
