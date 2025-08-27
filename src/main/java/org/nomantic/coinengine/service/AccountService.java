package org.nomantic.coinengine.service;

import jakarta.transaction.Transactional;
import org.nomantic.coinengine.dto.AccountCreateRequest;
import org.nomantic.coinengine.dto.DepositRequest;
import org.nomantic.coinengine.dto.TransferRequest;
import org.nomantic.coinengine.dto.WithdrawRequest;
import org.nomantic.coinengine.exception.AccountNotFoundException;
import org.nomantic.coinengine.model.Account;
import org.nomantic.coinengine.model.CheckingAccount;
import org.nomantic.coinengine.model.SavingsAccount;
import org.nomantic.coinengine.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    //account creation method
    @Transactional
    public Account createAccount(AccountCreateRequest request) {
        Account account;
        if("SAVINGS".equalsIgnoreCase(request.getAccountType())) {
            account = new SavingsAccount();
        } else if("CHECKING".equalsIgnoreCase(request.getAccountType())) {
            account = new CheckingAccount();
        } else {
            throw new IllegalArgumentException("Invalid account type: " + request.getAccountType());
        }
        account.setAccountHolderName(request.getAccountHolderName());
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(0.0);

        return accountRepository.save(account);
    }

    @Transactional
    public void deposit(DepositRequest request) {
        Account account = findAccountByNumber(request.getAccountNumber());
        account.deposit(request.getAmount());
        accountRepository.save(account);
    }

    public void withdraw(WithdrawRequest request) {
        Account account = findAccountByNumber(request.getAccountNumber());
        account.withdraw(request.getAmount());
        accountRepository.save(account);
    }

    public void transfer(TransferRequest request) {
        Account fromAccount = findAccountByNumber(request.getFromAccountNUmber());
        Account toAccount = findAccountByNumber(request.getToAccountNUmber());

        fromAccount.withdraw(request.getAmount());
        toAccount.deposit(request.getAmount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }

    public Account findAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with number: " + accountNumber));
    }
}
