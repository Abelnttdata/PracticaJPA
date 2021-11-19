package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Customer;
import com.example.practicaSpringModel.entity.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoanRepositoryDAO extends CrudRepository<Loan, Integer> {
    Optional<Loan> findLoanByLoanItem(String loanItem);
}
