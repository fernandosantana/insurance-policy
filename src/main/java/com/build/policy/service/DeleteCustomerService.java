package com.build.policy.service;

import com.build.policy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public DeleteCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void deleteById(String id) {
        this.customerRepository.deleteById(id);
    }
}
