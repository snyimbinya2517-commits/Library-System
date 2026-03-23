/*Author:
Date:
*/

package repository.impl;

import domain.Loan;
import domain.Reservation;
import repository.LoanRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LoanRepositoryImpl implements LoanRepository {

	private final Map<String, Loan> storage = new HashMap<>();

	private String keyFor(Loan loan) {
		return loan.getLoanId();
	}

    private static ReservationRepositoryImpl repository = null;


    public static ReservationRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ReservationRepositoryImpl();

        }
        return repository;

    }

	@Override
	public Loan create(Loan entity) {
		storage.put(keyFor(entity), entity);
		return entity;
	}

    @Override
    public Loan save(Loan entity) {
        return null;
    }

    @Override
	public Optional<Loan> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

    @Override
    public Optional<Loan> findById(String s) {
        return Optional.empty();
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
}
