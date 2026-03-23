/*Author:
Date:
*/
package repository.impl;

import domain.Publisher;
import domain.Reservation;
import repository.PublisherRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PublisherRepositoryImpl implements PublisherRepository {

	private final Map<String, Publisher> storage = new HashMap<>();
    private static ReservationRepositoryImpl repository = null;



    public static ReservationRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ReservationRepositoryImpl();

        }
        return repository;

    }

	@Override
	public Publisher create(Publisher entity) {
		storage.put(entity.getPublisherID(), entity);
		return entity;
	}

    @Override
    public Publisher save(Publisher entity) {
        return null;
    }

    @Override
	public Optional<Publisher> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

    @Override
    public Optional<Publisher> findById(String s) {
        return Optional.empty();
    }

    @Override
	public Publisher update(Publisher entity) {
		storage.put(entity.getPublisherID(), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}
}
