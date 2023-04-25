package com.example.demo.dao;

import com.example.demo.entities.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class CustomerDao {
    @PersistenceContext
    private EntityManager em;
    public List<Customer> findAll() {
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    public void add(Customer customer) {
        em.persist(customer);
        em.flush();
    }

    public List<Customer> findByName(String name) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByName", Customer.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
    public List<Customer> findByCardInterval(Long minCard, Long maxCard){
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByCardNumberRange", Customer.class);
        query.setParameter("minCard", minCard);
        query.setParameter("maxCard", maxCard);
        return query.getResultList();
    }


    public List<Customer> findByCardBalance() {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByCardBalance", Customer.class);
        return query.getResultList();
    }

    public List<Customer> findByBalanceORCard() {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByBalanceORCard", Customer.class);
        return query.getResultList();
    }

    public List<Integer> listYear() {
        TypedQuery<java.util.Date> query = em.createNamedQuery("Customer.listYear", Date.class);
        return query.getResultList().stream().map(date -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.YEAR);}).distinct().toList();
    }

    public Map<Integer, Customer> mapByYear() {
        Map<Integer, Customer> resultMap = new HashMap<>();
        try {
            TypedQuery<Customer> query = em.createNamedQuery("Customer.mapByYear", Customer.class);
            List<Customer> resultList = query.getResultList();
            for (Customer customer : resultList) {
                Integer year = customer.getBirthday().getYear();
                resultMap.put(year, customer);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultMap;
    }
}
