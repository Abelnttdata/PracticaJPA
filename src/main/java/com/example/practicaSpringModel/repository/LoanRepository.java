package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Customer;
import com.example.practicaSpringModel.entity.Loan;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Getter @Setter
public class LoanRepository {
    private ArrayList<Loan> loanArrayList = new ArrayList<>();

    @Autowired
    LoanRepositoryDAO loanRepositoryDAO;

    public void createLoan(Loan loan) {
        loanRepositoryDAO.save(loan);
    }

    public ArrayList<Loan> getAllLoans() {
        return (ArrayList<Loan>) loanRepositoryDAO.findAll();
    }

    public Optional<Loan> searchLoanByLoanItem(String loanItem) {
        return loanRepositoryDAO.findLoanByLoanItem(loanItem);
    }


    public Optional<Loan> searchLoan(String itemLoan){
        return loanArrayList.stream().filter(loan -> loan.getLoanItem().equalsIgnoreCase(itemLoan)).findFirst();
    }



}
