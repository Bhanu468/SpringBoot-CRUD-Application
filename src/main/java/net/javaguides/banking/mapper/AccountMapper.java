package net.javaguides.banking.mapper;

import net.javaguides.banking.dto.Accountdto;
import net.javaguides.banking.entity.Account;

public class AccountMapper {
    public static Account AccountMapper(Accountdto accountdto){
        Account account= new Account(
                accountdto.getId(),
                accountdto.getAccountHolderName(),
                accountdto.getBalance()
        );
        return account;
    }

    public  static Accountdto mapToAccountDto(Account account) {
        Accountdto accountdto=new Accountdto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountdto;
    }

}
