package factory;


//Member Factory Test.
//Author: 230240887 Nxasana Owenkosi
//Date: 16 March

import domain.Member;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemberFactoryTest {

    @Test
    void shouldCreateMemberUsingFactoryWithAllFields() {

        Member member = MemberFactory.createMember("M001", "Owe Nxasana", "owe@email.com", "0832234567");

        assertNotNull(member);
        assertEquals("M001", member.getMemberID());
        assertEquals("Owe Nxasana", member.getMemberName());
        assertEquals("owe@email.com", member.getMemberEmail());
        assertEquals("0832234567", member.getMemberPhone());
    }

    @Test
    void shouldCreateMemberUsingFactoryWithRequiredFields() {
        Member member = MemberFactory.createMember("M010", "Basic Member");

        assertNotNull(member);
        assertEquals("M010", member.getMemberID());
        assertEquals("Basic Member", member.getMemberName());
    }

    @Test
    void shouldThrowExceptionWhenIdIsMissing() {

        assertThrows(IllegalArgumentException.class, () -> {
            MemberFactory.createMember(null, "Owe");
        });
    }

    @Test
    void shouldThrowExceptionWhenIdIsInvalid() {

        assertThrows(IllegalArgumentException.class, () -> {
            MemberFactory.createMember("123", "Owe");
        });
    }

    @Test
    void shouldThrowExceptionWhenNameIsMissing() {

        assertThrows(IllegalArgumentException.class, () -> {
            MemberFactory.createMember("M002", "");
        });
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {

        assertThrows(IllegalArgumentException.class, () -> {
            MemberFactory.createMember("M003", "Owe", "invalid-email", "0830000000");
        });
    }
}
