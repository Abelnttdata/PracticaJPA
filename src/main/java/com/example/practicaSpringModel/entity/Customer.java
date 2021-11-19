package com.example.practicaSpringModel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="customers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @OneToMany(cascade = {CascadeType.ALL})
    @Column(name = "loans")
    private List<Loan> loanList;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String dni;
    private String address;
    //@ElementCollection @Column(name = "listLoans")
    //private Set<Loan> loans;

    public String getDni() {
        return dni;
    }


    public Customer(List<Loan> loanList, Integer id, String name, Integer age, String dni, String address) {
        this.loanList = loanList;
        this.id = id;
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.address = address;
    }

    public Customer(Integer id, String name, Integer age, String dni, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.address = address;
    }

    public Customer() {
    }


}
