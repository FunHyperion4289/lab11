package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
@NamedQueries({@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),

        @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name"),
        @NamedQuery(name = "Customer.findByCardNumberRange", query = "SELECT c FROM Customer c WHERE c.cardNumber BETWEEN :minCard AND :maxCard"),
        @NamedQuery(name = "Customer.findByCardBalance", query = "SELECT c FROM Customer c WHERE c.cardBalance < 0"),
        @NamedQuery(name = "Customer.findByBalanceORCard", query = "SELECT c FROM Customer c ORDER BY c.cardBalance ASC, c.cardNumber ASC"),
        @NamedQuery(name = "Customer.listYear", query = "SELECT c.birthday FROM Customer c"),
        @NamedQuery(name = "Customer.mapByYear", query = "SELECT c FROM Customer c")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCustomer", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "Surname", nullable = false, length = 45)
    private String surname;

    @Size(max = 45)
    @NotNull
    @Column(name = "Name", nullable = false, length = 45)
    private String name;

    @Size(max = 45)
    @NotNull
    @Column(name = "MiddleName", nullable = false, length = 45)
    private String middleName;

    @NotNull
    @Column(name = "Birthday", nullable = false)
    private java.util.Date birthday;

    @Size(max = 45)
    @NotNull
    @Column(name = "Adress", nullable = false, length = 45)
    private String adress;

    @NotNull
    @Column(name = "CardNumber", nullable = false)
    private Long cardNumber;

    @Column(name = "CardBalance")
    private Double cardBalance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public java.util.Date getBirthday() {

        return birthday;
    }

    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(Double cardBalance) {
        this.cardBalance = cardBalance;
    }

}