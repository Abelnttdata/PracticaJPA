package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CustomerRepositoryImp {
     @PersistenceContext
     private EntityManager entityManager;

     public List<Customer> findCustomerByAddress(String name, String address){
         CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
         CriteriaQuery<Customer>
     }


}
