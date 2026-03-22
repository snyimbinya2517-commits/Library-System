
package factory;

/*
 *Author: Sinazo Ntsimbi
 * 222765208
 * Date: 16 March 2026
 */

import domain.Loan;
import java.time.LocalDate;

public class LoanFactory {
    public static Loan createLoan(String loanId, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        return new Loan.Builder()
                .setLoanId(loanId)
                .setIssue(issueDate)
                .setDueDate(dueDate)
                .setReturnDate(returnDate)
                .build();

    }
}


