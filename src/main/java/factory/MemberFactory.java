/* MemberFactory.java
   Member factory class
   
*/
package factory;

import domain.Member;

/* Factory Member class
  Author: 230240887 Owenkosi Nxasana
  Date: 13 March 2026
*/

public class MemberFactory {

    public static Member createMember(String memberId, String name) {
        return new Member.Builder(memberId, name)
                .build();
    }

    public static Member createMember(String memberId, String name, String email, String phone) {
        return new Member.Builder(memberId, name)
                .setMemberEmail(email)
                .setMemberPhone(phone)
                .build();
    }

    public static String generateMemberId(int number) {
        return String.format("M%03d", number);
    }
}