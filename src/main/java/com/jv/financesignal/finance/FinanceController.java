package com.jv.financesignal.finance;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class FinanceController {
  private final FinanceService service;
  public FinanceController(FinanceService service){this.service=service;}
  @PostMapping FinanceDtos.TransactionResponse create(@Valid @RequestBody FinanceDtos.CreateTransactionRequest request){ return service.create(request); }
  @GetMapping List<FinanceDtos.TransactionResponse> list(){ return service.list(); }
}
