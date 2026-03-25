/**
 * Author: Sinazo Ntsimbi
 * 222765208
 * Date: 23 March 2026
*/

package repository.impl;

import domain.Loan;
import repository.LoanRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LoanRepositoryImpl implements LoanRepository {

	private final Map<String, Loan> storage = new HashMap<>();

	private String keyFor(Loan loan) {
		return loan.getLoanId();
	}

	@Override
	public Loan create(Loan entity) {
		storage.put(keyFor(entity), entity);
		return entity;
	}

	@Override
	public Optional<Loan> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public Loan update(Loan entity) {
		storage.put(keyFor(entity), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}

	@Override
	public Collection<Loan> getAll() {
		return storage.values();
	}
}

