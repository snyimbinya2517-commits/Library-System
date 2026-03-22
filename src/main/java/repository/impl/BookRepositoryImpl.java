package repository.impl;


/*
  Author: Nomhle Ngengele 216227488
  Date: 16 March 2026
* */


import domain.Book;
import repository.BookRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

	private final Map<String, Book> storage = new HashMap<>();

	private String keyFor(Book book) {
		return book.hashCode() + "";
	}

	@Override
	public Book create(Book entity) {
		storage.put(keyFor(entity), entity);
		return entity;
	}

	@Override
	public Optional<Book> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public Book update(Book entity) {
		storage.put(keyFor(entity), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}
	//End or program
}
