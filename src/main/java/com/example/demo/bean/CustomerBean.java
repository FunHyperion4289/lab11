package com.example.demo.bean;
import com.example.demo.entities.Customer;
import com.example.demo.dao.CustomerDao;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@Data
@Named
@SessionScoped
public class CustomerBean implements Serializable {
    @EJB
    private CustomerDao customerDao;
    private Customer customer = new Customer();

    String surname;
    String name;
    String middleName;
    LocalDate birthday;
    String adress;
    long cardNumber;
    double cardBalance;
    long minCard;
    long maxCard;
    @PostConstruct
    public void init(){
        customer = new Customer();
        surname = "";
        name = "";
        middleName = "";
        birthday = LocalDate.ofEpochDay(0000-00-00);
        adress = "";
        cardNumber = 0L;
        cardBalance = 0.0;
        minCard = 0L;
        maxCard = 0L;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public long getMinCard() {
        return minCard;
    }

    public void setMinCard(long minCard) {
        this.minCard = minCard;
    }

    public long getMaxCard() {
        return maxCard;
    }

    public void setMaxCard(long maxCard) {
        this.maxCard = maxCard;
    }


    public List<Customer> getCustomers(){
        return customerDao.findAll();
    }
    public void add(){
        customerDao.add(customer);
        customer = new Customer();
    }
    public List<Customer> findByName(String name){
        return customerDao.findByName(name);
    }
    public List<Customer> findByCardInterval(long minCard, long maxCard){
        return customerDao.findByCardInterval(minCard, maxCard);
    }
    public List<Customer> findByCardBalance(){
        return customerDao.findByCardBalance();
    }
    public List<Customer> findByBalanceORCard(){
        return customerDao.findByBalanceORCard();
    }
    public List<Integer> listYears(){
        return customerDao.listYear();
    }
    public Map<Integer, Customer> mapByYear(){
        return customerDao.mapByYear();
    }
}
