package net.javaguides.banking.service.impl;

import net.javaguides.banking.dto.Accountdto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.mapper.AccountMapper;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Accountdto createAccount(Accountdto accountdto) {
        Account account = AccountMapper.AccountMapper(accountdto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public Accountdto getAccountById(Long id) {
        Account account= accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account doesn't exist"));
        return AccountMapper.mapToAccountDto(account);
    }




}
