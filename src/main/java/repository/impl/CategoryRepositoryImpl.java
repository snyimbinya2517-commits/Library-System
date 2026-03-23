/*Author: Ngwana Tiyani 231266731
Date: 16 March 2026
*/

package repository.impl;

import domain.Category;
import domain.Reservation;
import repository.CategoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {

	private final Map<String, Category> storage = new HashMap<>();

    private static ReservationRepositoryImpl repository = null;



    public static ReservationRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ReservationRepositoryImpl();

        }
        return repository;

    }

	@Override
	public Category create(Category entity) {
		storage.put(entity.getCategoryId(), entity);
		return entity;
	}

    @Override
    public Category save(Category entity) {
        return null;
    }

    @Override
	public Optional<Category> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

    @Override
    public Optional<Category> findById(String s) {
        return Optional.empty();
    }

    @Override
	public Category update(Category entity) {
		storage.put(entity.getCategoryId(), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}


	@Override
	public Optional<Category> findByName(String name) {
		return storage.values().stream()
				.filter(category -> category.getName().equalsIgnoreCase(name))
				.findFirst();
	}

	@Override
	public List<Category> findByNameContaining(String keyword) {
		return storage.values().stream()
				.filter(category -> category.getName().toLowerCase().contains(keyword.toLowerCase()))
				.toList();
	}

	@Override
	public boolean existsByName(String name) {
		return storage.values().stream()
				.anyMatch(category -> category.getName().equalsIgnoreCase(name));
	}
}
