
package factory;
/**
 *Author: Sinazo Ntsimbi
 * 222765208
 */

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


