package net.javaguides.banking.controller;

import net.javaguides.banking.dto.Accountdto;
import net.javaguides.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/{id}")
    public ResponseEntity<Accountdto> getAccountbyId(@PathVariable Long id){
        Accountdto accountdto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountdto);
    }

    //Deposit REST API
    //PutMapping is for incoming HTTP Request
    @PutMapping("/{id}/deposit")
    //RequestBody maps the annotation will map the request JSON body into this map java object
    public  ResponseEntity<Accountdto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount=request.get("amount");
        Accountdto accountdto= accountService.deposit(id,amount);
        return ResponseEntity.ok(accountdto);
    }
    //WITHDRAW RESTAPI
    @PutMapping("/{id}/withdraw")
    public  ResponseEntity<Accountdto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
        double amount = request.get("amount");
        Accountdto accountdto= accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountdto);
    }

    //Get ALL accounts rest api
    @GetMapping
    public ResponseEntity<List<Accountdto>> getAllAccounts(){
        List<Accountdto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //delete account REST API

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully!");
    }




}
