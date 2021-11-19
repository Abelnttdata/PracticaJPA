package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Customer;
import com.example.practicaSpringModel.entity.CustomertwoValues;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Getter @Setter
public class CustomerRepository {
    private ArrayList<Customer> customers = new ArrayList<>();

    @Autowired
    CustomerRepositoryDAO customerRepositoryDAO;

    //Guarda datos en la tabla
    public void createCustomer(Customer customer){
        customerRepositoryDAO.save(customer);
    }
    public List<Customer> getAllCustomers(){
        return (List<Customer>) customerRepositoryDAO.findAll();
    }

    public Optional<Customer> getCustomerByNameAndAge(String name, Integer age) {
        return customerRepositoryDAO.getCustomerByNameAndAge(name, age);
    }
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepositoryDAO.findById(id);
    }

    public Optional<Customer> getCustomerByNameAndAgeByQuery(String name, Integer age) {
        return customerRepositoryDAO.findCustomerByNameAndAgeByQuery(name, age);
    }

    public void deleteCustomer(Integer id) {
        customerRepositoryDAO.deleteById(id);
    }

    public List<String> getCustomerByAge(Integer age) {
        return customerRepositoryDAO.findCustomerByAgeByQueryPersonalized(age);
    }

    public List<CustomertwoValues> getCustomerByAge2(Integer age) {
        return customerRepositoryDAO.findCustomerByAgeByQueryPersonalized2(age);
    }

    public List<Customer> getCustomerJoin(String name) {
        return customerRepositoryDAO.findCustomerByJoin(name);
    }



    /*
    public Optional<Customer> searchCustomer(String dni){
        return customers.stream().filter(customer -> customer.getDni().equalsIgnoreCase(dni)).findFirst();
    }
     */
}
