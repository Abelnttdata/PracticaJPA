package com.example.practicaSpringModel.controller;


import com.example.practicaSpringModel.entity.Customer;
import com.example.practicaSpringModel.entity.CustomertwoValues;
import com.example.practicaSpringModel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @PostMapping("/createcustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerRepository.createCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{name}/{age}")
    public ResponseEntity<Customer> getCustomerByNameAndAge(@PathVariable("name") String name,@PathVariable("age") Integer age) throws nonexistentClientException {
        Optional<Customer> optionalCustomer= customerRepository.getCustomerByNameAndAge(name,age);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        return ResponseEntity.ok(optionalCustomer.get());
    }
    @GetMapping("byage/{age}")
    public List<String> getCustomerByAge(@PathVariable("age") Integer age){
        return customerRepository.getCustomerByAge(age);

    }

    @GetMapping("byagelist/{age}")
    public List<CustomertwoValues> getCustomerByAge2(@PathVariable("age") Integer age) {
         return customerRepository.getCustomerByAge2(age);
    }


    @GetMapping("byjoin/{name}")
    public List<Customer> getCustomerJoin(@PathVariable("name") String name) {
        return customerRepository.getCustomerJoin(name);
    }



    /*
    @GetMapping("byquery/{name}/{age}")
    public ResponseEntity<Customer> getCustomerByNameAndAgeQuery(@PathVariable("name") String name,@PathVariable("age") Integer age) throws nonexistentClientException {
        Optional<Customer> optionalCustomer= customerRepository.getCustomerByNameAndAgeByQuery(name,age);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        return ResponseEntity.ok(optionalCustomer.get());
    }
 */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Customer> deleteCustomerException(@PathVariable Integer id) throws nonexistentClientException {
        Optional<Customer> optionalCustomer = customerRepository.getCustomerById(id);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        customerRepository.deleteCustomer(id);
        return ResponseEntity.ok(optionalCustomer.get());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Customer> updateCustomerException(@PathVariable Integer id, @RequestBody Customer customer) throws nonexistentClientException{
        Optional<Customer> optionalCustomer = customerRepository.getCustomerById(id);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        //customerRepository.createCustomer();
        return ResponseEntity.ok(optionalCustomer.get());
    }





    //@Autowired
    //ModelMapper modelMapper;
    /*
    @GetMapping
    public ArrayList<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Customer> getCustomers(@PathVariable String dni) throws nonexistentClientException {
        Optional<Customer> optionalCustomer= customerRepository.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        return ResponseEntity.ok(optionalCustomer.get());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        System.out.println("Se hizo la solicitud de crear cliente");
        customerRepository.getCustomers().add(customer);
        return ResponseEntity.ok(customer);
    }


    @DeleteMapping("/{dni}")
    public ResponseEntity<Customer> deleteCustomerException(@PathVariable String dni) throws nonexistentClientException {
        Optional<Customer> optionalCustomer = customerRepository.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        deleteCustomer(dni);
        return ResponseEntity.ok(optionalCustomer.get());
    }


    public void deleteCustomer(String dni){
        Optional<Customer> optionalCustomer= customerRepository.searchCustomer(dni);
        optionalCustomer.ifPresent(value -> customerRepository.getCustomers().remove(value));
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Customer> updateCustomerException(@PathVariable String dni) throws nonexistentClientException{
        Optional<Customer> optionalCustomer = customerRepository.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
       // updateCustomer();
        return ResponseEntity.ok(optionalCustomer.get());
    }

    public void updateCustomer(Customer customer){
        deleteCustomer(customer.getDni());
        customerRepository.getCustomers().add(customer);
    }

     */

}
