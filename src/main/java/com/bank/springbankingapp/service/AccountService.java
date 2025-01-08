package com.bank.springbankingapp.service;

import com.bank.springbankingapp.dto.AccountDTO;

public interface AccountService {

    AccountDTO createAccount(AccountDTO account);

    AccountDTO getAccountById(Long id);
}
