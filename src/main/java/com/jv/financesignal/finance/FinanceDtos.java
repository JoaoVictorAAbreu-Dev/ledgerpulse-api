package com.jv.financesignal.finance;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public final class FinanceDtos {
  private FinanceDtos() {}
  public record CreateTransactionRequest(@NotBlank @Size(max = 120) String title, @NotNull @DecimalMin("0.01") BigDecimal amount, @NotNull TransactionType type, @NotNull Category category, LocalDate transactionDate, boolean recurring) {}
  public record TransactionResponse(UUID id, String title, BigDecimal amount, TransactionType type, Category category, LocalDate transactionDate, boolean recurring, LocalDateTime createdAt) {}
  public record BudgetSnapshot(BigDecimal income, BigDecimal expenses, BigDecimal balance, long recurringCount, int alertScore) {}
}
