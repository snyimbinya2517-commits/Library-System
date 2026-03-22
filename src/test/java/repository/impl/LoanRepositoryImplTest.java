/*
Author:
Date: 
*/
package repository.impl;

import domain.Loan;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanRepositoryImplTest {

    @Test
    void testCreateReadUpdateDelete() {
        LoanRepositoryImpl repository = new LoanRepositoryImpl();

        Loan loan = new Loan.Builder().setLoanId("L001").setIssue(LocalDate.of(2026, 3, 20)).setDueDate(LocalDate.of(2026, 3, 27)).setReturnDate(null).build();
        repository.create(loan);

        assertTrue(repository.read("L001").isPresent());

        Loan updatedLoan = new Loan.Builder().setLoanId("L001").setIssue(LocalDate.of(2026, 3, 20)).setDueDate(LocalDate.of(2026, 3, 30)).setReturnDate(null).build();
        repository.update(updatedLoan);
        assertTrue(repository.read("L001").isPresent());

        assertTrue(repository.delete("L001"));
        assertFalse(repository.read("L001").isPresent());
    }
}

