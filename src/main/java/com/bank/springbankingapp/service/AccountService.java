package com.bank.springbankingapp.service;

import com.bank.springbankingapp.dto.AccountDTO;

public interface AccountService {

    AccountDTO createAccount(AccountDTO account);

    AccountDTO getAccountById(Long id);

    AccountDTO deposit(Long id, Double amount);

    AccountDTO withdraw(Long id, Double amount);
}
