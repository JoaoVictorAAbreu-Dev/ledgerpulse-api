package com.jv.financesignal.dashboard;

import com.jv.financesignal.finance.FinanceDtos;
import com.jv.financesignal.finance.FinanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanceDashboardController {
  private final FinanceService service;
  public FinanceDashboardController(FinanceService service){this.service=service;}
  @GetMapping("/api/dashboard")
  FinanceDtos.BudgetSnapshot snapshot(){ return service.snapshot(); }
}
