package com.build.policy.service;

import com.build.policy.dto.CreateCustomerRequest;
import com.build.policy.dto.UpdateCustomerRequest;
import com.build.policy.model.Customer;
import com.build.policy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveCustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public SaveCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(CreateCustomerRequest createCustomer) {
        Customer customer = new Customer();
        customer.setCity(createCustomer.getCity());
        customer.setCpf(createCustomer.getCpf());
        customer.setName(createCustomer.getName());
        customer.setUf(createCustomer.getUf());

        return this.customerRepository.save(customer);
    }

    public Customer update(Customer customer, UpdateCustomerRequest updateCustomerRequest) {
        customer.setCity(updateCustomerRequest.getCity());
        customer.setCpf(updateCustomerRequest.getCpf());
        customer.setName(updateCustomerRequest.getName());
        customer.setUf(updateCustomerRequest.getUf());

        return this.customerRepository.save(customer);
    }
}
