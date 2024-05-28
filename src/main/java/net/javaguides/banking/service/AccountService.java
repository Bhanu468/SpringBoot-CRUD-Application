package net.javaguides.banking.service;

import net.javaguides.banking.dto.Accountdto;
import net.javaguides.banking.entity.Account;

public interface AccountService {
    Accountdto createAccount(Accountdto accountdto);

    Accountdto getAccountById(Long id);
}
