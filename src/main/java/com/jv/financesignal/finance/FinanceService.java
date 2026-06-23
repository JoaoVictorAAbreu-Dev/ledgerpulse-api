package com.jv.financesignal.finance;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class FinanceService {
  private final TransactionRepository repository;
  public FinanceService(TransactionRepository repository){this.repository = repository;}
  public FinanceDtos.TransactionResponse create(FinanceDtos.CreateTransactionRequest request){
    var tx = new TransactionEntity();
    tx.setTitle(request.title().trim()); tx.setAmount(request.amount()); tx.setType(request.type()); tx.setCategory(request.category()); tx.setTransactionDate(request.transactionDate()); tx.setRecurring(request.recurring());
    return toResponse(repository.save(tx));
  }
  @Transactional(readOnly = true)
  public List<FinanceDtos.TransactionResponse> list(){ return repository.findAllByOrderByTransactionDateDescCreatedAtDesc().stream().map(this::toResponse).toList(); }
  @Transactional(readOnly = true)
  public FinanceDtos.BudgetSnapshot snapshot(){
    var all = repository.findAll();
    BigDecimal income = all.stream().filter(t -> t.getType()==TransactionType.INCOME).map(TransactionEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    BigDecimal expenses = all.stream().filter(t -> t.getType()==TransactionType.EXPENSE).map(TransactionEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    long recurring = all.stream().filter(TransactionEntity::isRecurring).count();
    var balance = income.subtract(expenses);
    var alertScore = Math.max(0, 100 - (int) Math.max(0, expenses.subtract(income).doubleValue() * 2) - (int) recurring * 5);
    return new FinanceDtos.BudgetSnapshot(income, expenses, balance, recurring, alertScore);
  }
  private FinanceDtos.TransactionResponse toResponse(TransactionEntity tx){ return new FinanceDtos.TransactionResponse(tx.getId(), tx.getTitle(), tx.getAmount(), tx.getType(), tx.getCategory(), tx.getTransactionDate(), tx.isRecurring(), tx.getCreatedAt());}
}
