package com.jv.financesignal.finance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FinanceServiceTest {
  @Mock TransactionRepository repository;
  @InjectMocks FinanceService service;

  @Test
  void createShouldPersistIncomeTransaction() {
    when(repository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
    var response = service.create(new FinanceDtos.CreateTransactionRequest("Salary", new BigDecimal("5000.00"), TransactionType.INCOME, Category.HOUSING, LocalDate.now(), false));
    assertThat(response.type()).isEqualTo(TransactionType.INCOME);
    assertThat(response.amount()).isEqualByComparingTo("5000.00");
  }

  @Test
  void snapshotShouldComputeBalanceAndAlerts() {
    var income = new TransactionEntity();
    income.setTitle("Salary");
    income.setAmount(new BigDecimal("5000.00"));
    income.setType(TransactionType.INCOME);
    income.setCategory(Category.OTHER);
    income.setRecurring(false);
    var expense = new TransactionEntity();
    expense.setTitle("Rent");
    expense.setAmount(new BigDecimal("2200.00"));
    expense.setType(TransactionType.EXPENSE);
    expense.setCategory(Category.HOUSING);
    expense.setRecurring(true);
    when(repository.findAll()).thenReturn(java.util.List.of(income, expense));
    var snapshot = service.snapshot();
    assertThat(snapshot.balance()).isEqualByComparingTo("2800.00");
    assertThat(snapshot.recurringCount()).isEqualTo(1);
  }

}
