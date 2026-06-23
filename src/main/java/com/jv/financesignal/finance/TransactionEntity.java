package com.jv.financesignal.finance;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class TransactionEntity {
  @Id @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(nullable = false, length = 120) private String title;
  @Column(nullable = false, precision = 12, scale = 2) private BigDecimal amount;
  @Enumerated(EnumType.STRING) @Column(nullable = false, length = 20) private TransactionType type;
  @Enumerated(EnumType.STRING) @Column(nullable = false, length = 20) private Category category;
  private LocalDate transactionDate;
  @Column(nullable = false) private boolean recurring;
  @Column(nullable = false, updatable = false) private LocalDateTime createdAt;

  @PrePersist void prePersist() {
    if (transactionDate == null) transactionDate = LocalDate.now();
    createdAt = LocalDateTime.now();
  }
  public UUID getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
  public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;}
  public TransactionType getType(){return type;} public void setType(TransactionType v){type=v;}
  public Category getCategory(){return category;} public void setCategory(Category v){category=v;}
  public LocalDate getTransactionDate(){return transactionDate;} public void setTransactionDate(LocalDate v){transactionDate=v;}
  public boolean isRecurring(){return recurring;} public void setRecurring(boolean v){recurring=v;}
  public LocalDateTime getCreatedAt(){return createdAt;}
}
