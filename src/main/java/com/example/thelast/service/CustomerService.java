package com.example.thelast.service;

import com.example.thelast.model.Customer;
import com.example.thelast.dao.CustomerDAO;
import com.example.thelast.exception.CustomerNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    public Customer addCustomer(Customer customer){
        return  customerDAO.save(customer);

    }

    public List <Customer> getCustomer(){
        return  customerDAO.findAll();
    }

    public Customer getCustomer(int customerId){

        Optional<Customer> optionalCustomer = customerDAO.findById((customerId));

        if (optionalCustomer.isEmpty())
            throw new CustomerNotFound("Customer record is not available");

        return optionalCustomer.get();

    }

    public Customer updateCustomer(int customerId, Customer customer ){
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId){
     customerDAO.deleteById(customerId);
    }
}
