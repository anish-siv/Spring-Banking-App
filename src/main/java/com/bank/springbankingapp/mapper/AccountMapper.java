package com.bank.springbankingapp.mapper;

import com.bank.springbankingapp.dto.AccountDTO;
import com.bank.springbankingapp.model.Account;

public class AccountMapper {

    public static Account maptoAccount(AccountDTO accountDTO) {
        Account account = new Account(
                accountDTO.getId(),
                accountDTO.getAccountHolderName(),
                accountDTO.getBalance()
        );

        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );

        return accountDTO;
    }
}
