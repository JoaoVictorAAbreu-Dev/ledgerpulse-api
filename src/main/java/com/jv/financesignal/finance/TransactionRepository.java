package com.jv.financesignal.finance;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {
  List<TransactionEntity> findAllByOrderByTransactionDateDescCreatedAtDesc();
}
