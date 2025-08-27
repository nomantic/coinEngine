package org.nomantic.coinengine.service;

import org.nomantic.coinengine.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    /**
     * Generates a simple report for a list of accounts.
     * This method uses an upper-bounded wildcard (<? extends Account>)
     * to accept a List of Account, or a List of any of its subclasses
     * (e.g., List<SavingsAccount>, List<CheckingAccount>).
     */
    public String generateAccountSummary(List<? extends Account> accounts) {
        StringBuilder report = new StringBuilder("Account Summary\n");
        for (Account account : accounts) {
            report.append(String.format("Holder: %s | Account: %s | Type: %s | Balance: %.2f\n",
                    account.getAccountHolderName(),
                    account.getAccountType(),
                    account.getAccountNumber(),
                    account.getBalance()
                    ));
        }
        return report.toString();
    }

}
