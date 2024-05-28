package net.javaguides.banking.controller;

import net.javaguides.banking.dto.Accountdto;
import net.javaguides.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    //above field is declared

    //@autowired is not needed the above field is injected using constructor.
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add Account REST API
    //using spring we can create a REST API
    // declare the method and annotate.

    @PostMapping
    public ResponseEntity<Accountdto>  addAccount(@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);
    }

    //Get Account REST API
    public ResponseEntity<Accountdto> getAccountbyId(Long id){
        Accountdto accountdto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountdto);
    }



}
