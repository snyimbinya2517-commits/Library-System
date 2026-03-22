/* MemberRepositoryImpl.java
   Member repository implementation
   Author:
   Date: 13 March 2026
*/
package repository.impl;

import domain.Member;
import repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemberRepositoryImpl implements MemberRepository {

    private final Map<String, Member> storage = new HashMap<>();

    private String keyFor(Member member) {
        return member.getMemberID();
    }

    @Override
    public Member create(Member entity) {
        storage.put(keyFor(entity), entity);
        return entity;
    }

    @Override
    public Optional<Member> read(String id) {
        return Optional.ofNullable(storage.get(id));
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

