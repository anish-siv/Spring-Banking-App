package com.bank.springbankingapp.service.implementation;

import com.bank.springbankingapp.dto.AccountDTO;
import com.bank.springbankingapp.mapper.AccountMapper;
import com.bank.springbankingapp.model.Account;
import com.bank.springbankingapp.repository.AccountRepository;
import com.bank.springbankingapp.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImplementation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.maptoAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }
}
