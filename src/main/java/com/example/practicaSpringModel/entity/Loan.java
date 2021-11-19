package com.example.practicaSpringModel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter @Setter
@Table(name = "loans")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String date;
    private  String loanItem;
    private String dateOfDevolution;
    private String estado;
    //private Customer customer;


    public Loan() {
    }

}
