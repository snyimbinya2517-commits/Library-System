package factory;
/*
*Author: Sinazo Ntsimbi
* 222765208
 */
import domain.Loan;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class LoanFactoryTest {

	@Test
	void testCreateLoan() {
		LocalDate issueDate = LocalDate.of(2026, 3, 20);
		LocalDate dueDate = LocalDate.of(2026, 3, 27);
		LocalDate returnDate = LocalDate.of(2026, 3, 25);

		Loan loan = LoanFactory.createLoan("L001", issueDate, dueDate, returnDate);

		assertNotNull(loan);
		assertEquals("L001", loan.getLoanId());
		assertEquals(issueDate, loan.getIssueDate());
		assertEquals(dueDate, loan.getDueDate());
		assertEquals(returnDate, loan.getReturnDate());
	}
}
