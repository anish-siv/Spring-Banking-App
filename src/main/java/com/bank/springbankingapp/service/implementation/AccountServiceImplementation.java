package com.bank.springbankingapp.service.implementation;

import com.bank.springbankingapp.dto.AccountDTO;
import com.bank.springbankingapp.mapper.AccountMapper;
import com.bank.springbankingapp.model.Account;
import com.bank.springbankingapp.repository.AccountRepository;
import com.bank.springbankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AccountDTO getAccountById(Long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist."));

        return AccountMapper.mapToAccountDTO(account);
    }

    @Override
    public AccountDTO deposit(Long id, Double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist."));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO withdraw(Long id, Double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist."));

        // If the withdrawal amount is greater than current balance, throw a runtime exception.
        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance.");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDTO(account))
                .collect(Collectors.toList());
    }
}
