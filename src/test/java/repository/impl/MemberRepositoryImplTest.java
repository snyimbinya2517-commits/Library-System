package repository.impl;

import domain.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryImplTest {

    @Test
    void testCreateReadUpdateDelete() {
        MemberRepositoryImpl repository = new MemberRepositoryImpl();

        Member member = new Member.Builder("M001", "Owen").setMemberEmail("owen@email.com").setMemberPhone("0831111111").build();
        repository.create(member);

        assertTrue(repository.read("M001").isPresent());

        Member updatedMember = new Member.Builder("M001", "Owen Updated").setMemberEmail("owen@email.com").setMemberPhone("0831111111").build();
        repository.update(updatedMember);
        assertTrue(repository.read("M001").isPresent());

        assertTrue(repository.delete("M001"));
        assertFalse(repository.read("M001").isPresent());
    }
}

