package com.build.policy.service;

import com.build.policy.exception.NotFoundException;
import com.build.policy.model.Customer;
import com.build.policy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindCustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public FindCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    public Customer findById(String id) throws NotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(id);
        if(!optionalCustomer.isPresent()) {
            throw new NotFoundException("Customer not found");
        }

        return optionalCustomer.get();
    }
}
