package org.nomantic.coinengine.controller;

import jakarta.validation.Valid;
import org.nomantic.coinengine.dto.AccountCreateRequest;
import org.nomantic.coinengine.dto.DepositRequest;
import org.nomantic.coinengine.dto.TransferRequest;
import org.nomantic.coinengine.dto.WithdrawRequest;
import org.nomantic.coinengine.model.Account;
import org.nomantic.coinengine.repository.AccountRepository;
import org.nomantic.coinengine.service.AccountService;
import org.nomantic.coinengine.service.ReportService;
import org.nomantic.coinengine.utill.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<ApiResponse<Account>> createAccount(@Valid @RequestBody AccountCreateRequest request) {
        Account newAccount = accountService.createAccount(request);
        ApiResponse<Account> response = new ApiResponse<>(true, "Account created successfully", newAccount);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<ApiResponse<Account>> getAccount(@PathVariable String accountNumber) {
        Account account = accountService.findAccountByNumber(accountNumber);
        return ResponseEntity.ok(new ApiResponse<Account>(true, "Account found", account));
    }

    @PostMapping("/deposit")
    public ResponseEntity<ApiResponse<String>> deposit(@RequestBody DepositRequest request) {
        accountService.deposit(request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Deposit successful", null));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<ApiResponse<String>> withdraw(@RequestBody WithdrawRequest request) {
        accountService.withdraw(request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Withdraw successful", null));
    }

    @PostMapping("/transfer")
    public ResponseEntity<ApiResponse<String>> transfer(@RequestBody TransferRequest request) {
        accountService.transfer(request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Transfer successful", null));
    }

    // Endpoint to practice Wildcards
    @GetMapping("/report")
    public ResponseEntity<String> getAccountReport() {
        List<Account> allAccounts = (List<Account>) accountRepository.findAll();
        String report = reportService.generateAccountSummary(allAccounts); //wildcard method usage
        return ResponseEntity.ok(report);

    }



}
