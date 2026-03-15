/* LoanFactory.java
   Loan factory class
   Author: Sinazo Ntsimbi (22765208)
   Date: 13 March 2026
*/
package factory;

import domain.Loan;
import java.time.LocalDate;

public class LoanFactory {
    public static Loan createloan(String loanId, LocalDate isssueDate, localDate dueDate, localDate returnDate) {
        return new Loan.Builder()
                .setLoanId(loanId)
                .setIsshueDate(isssueDate)
                .setDueDate(dueDate)
                .setReturnDate(returnDate)
                .build();
    }
}


