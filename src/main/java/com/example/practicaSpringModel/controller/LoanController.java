package com.example.practicaSpringModel.controller;

import com.example.practicaSpringModel.entity.Customer;
import com.example.practicaSpringModel.entity.Loan;
import com.example.practicaSpringModel.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanRepository loanRepository;

    @PostMapping("/createloan")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan){
        loanRepository.createLoan(loan);
        return ResponseEntity.ok(loan);
    }

    @GetMapping
    public  ArrayList<Loan> getAllLoans() {
        return loanRepository.getAllLoans();
    }

    @GetMapping("/{loanItem}")
    public ResponseEntity<Loan> getLoan(@PathVariable String loanItem) throws nonexistentLoanException {
        Optional<Loan> optionalLoan= loanRepository.searchLoanByLoanItem(loanItem);
        if(optionalLoan.isEmpty()){
            throw new nonexistentLoanException();
        }
        return ResponseEntity.ok(optionalLoan.get());
    }


    /*
    @GetMapping
    public  ArrayList<Loan> getLoans() {
        System.out.println("Se hizo la consulta de los productos");
        return loanRepository.getLoanArrayList();
    }

    @GetMapping("/{loanItem}")
    public ResponseEntity<Loan> getLoan(@PathVariable String loanItem) throws nonexistentLoanException {
        Optional<Loan> optionalLoan= loanRepository.searchLoan(loanItem);
        System.out.println("Se hizo la consulta de los productos");
        if(optionalLoan.isEmpty()){
            throw new nonexistentLoanException();
        }
        return ResponseEntity.ok(optionalLoan.get());
    }

    @PostMapping
    public ResponseEntity<Loan> createCustomer(@RequestBody Loan loan){
        System.out.println("Se hizo la solicitud de crear producto");
        loanRepository.getLoanArrayList().add(loan);
        return ResponseEntity.ok(loan);
    }


    @DeleteMapping("/{loanItem}")
    public ResponseEntity<Loan> deleteLoanException(@PathVariable String loanItem) throws nonexistentLoanException {
        System.out.println("Se hizo solicitud de eliminacion de productos");
        Optional<Loan> optionalLoan = loanRepository.searchLoan(loanItem);
        if(optionalLoan.isEmpty()){
            throw new nonexistentLoanException();
        }
        deleteLoan(loanItem);
        return ResponseEntity.ok(optionalLoan.get());
    }


    public void deleteLoan(String loanItem){
        Optional<Loan> optionalLoan= loanRepository.searchLoan(loanItem);
        optionalLoan.ifPresent(value -> loanRepository.getLoanArrayList().remove(value));
    }

    @PutMapping("/{loanItem}")
    public ResponseEntity<Loan> updateLoanException(@PathVariable String loanItem,@RequestBody Loan loan) throws nonexistentLoanException{
        Optional<Loan> optionalLoan = loanRepository.searchLoan(loanItem);
        if(optionalLoan.isEmpty()){
            throw new nonexistentLoanException();
        }
        updateLoan(loan,loanItem);
        return ResponseEntity.ok(optionalLoan.get());
    }


    public void updateLoan(Loan loan, String loanItem){
        deleteLoan(loanItem);
        loanRepository.getLoanArrayList().add(loan);
    }
     */
}
