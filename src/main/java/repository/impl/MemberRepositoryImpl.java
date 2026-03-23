/* MemberRepositoryImpl.java
   Member repository implementation
   Author:
   Date: 13 March 2026.
*/
package repository.impl;

import domain.Member;
import domain.Reservation;
import repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemberRepositoryImpl implements MemberRepository {

    private final Map<String, Member> storage = new HashMap<>();

    private String keyFor(Member member) {
        return member.getMemberID();
    }

    private static ReservationRepositoryImpl repository = null;



    public static ReservationRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ReservationRepositoryImpl();

        }
        return repository;

    }

    @Override
    public Member create(Member entity) {
        storage.put(keyFor(entity), entity);
        return entity;
    }

    @Override
    public Member save(Member entity) {
        return null;
    }

    @Override
    public Optional<Member> read(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Optional<Member> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Member update(Member entity) {
        storage.put(keyFor(entity), entity);
        return entity;
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id) != null;
    }


}

