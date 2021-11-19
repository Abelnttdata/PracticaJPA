package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Customer;
import com.example.practicaSpringModel.entity.CustomertwoValues;
import com.example.practicaSpringModel.entity.Loan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryDAO extends CrudRepository<Customer, Integer> {

    public Optional<Customer> getCustomerByNameAndAge(String name, Integer age);

    @Query(value = "select * from customer where name=:name and age=:age", nativeQuery = true )
    Optional<Customer> findCustomerByNameAndAgeByQuery(String name, Integer age);

    @Query(value = "select c.name from customer c where c.age=:age  ")
    public List<String> findCustomerByAgeByQueryPersonalized(Integer age);

    @Query(value = "select com.example.practicaSpringModel.entity(c.name, c.address) from customer c where c.age=:age  ")
    public List<CustomertwoValues>  findCustomerByAgeByQueryPersonalized2(Integer age);

    @Query(value = "select c  from customers c join c.loanList")
    public List<Customer>  findCustomerByJoin(String name);
}
