package com.build.policy.core;

import com.build.policy.dto.CreateCustomerRequest;
import com.build.policy.dto.UpdateCustomerRequest;
import com.build.policy.model.Customer;
import com.build.policy.service.DeleteCustomerService;
import com.build.policy.service.FindCustomerService;
import com.build.policy.service.SaveCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCore {

    private SaveCustomerService saveCustomerService;
    private FindCustomerService findCustomerService;
    private DeleteCustomerService deleteCustomerService;

    @Autowired
    public CustomerCore(SaveCustomerService saveCustomerService, FindCustomerService findCustomerService,
                        DeleteCustomerService deleteCustomerService) {
        this.saveCustomerService = saveCustomerService;
        this.findCustomerService = findCustomerService;
        this.deleteCustomerService = deleteCustomerService;
    }

    public Customer save(CreateCustomerRequest createCustomer) {
        return this.saveCustomerService.save(createCustomer);
    }

    public Customer update(String customerId, UpdateCustomerRequest updateCustomerRequest) throws Exception {
        Customer customer = this.findCustomerService.findById(customerId);
        return this.saveCustomerService.update(customer, updateCustomerRequest);
    }

    public List<Customer> findAll() {
        return this.findCustomerService.findAll();
    }

    public Customer findById(String id) throws Exception {
        return this.findCustomerService.findById(id);
    }

    public void deleteById(String id) {
        this.deleteCustomerService.deleteById(id);
    }
}
