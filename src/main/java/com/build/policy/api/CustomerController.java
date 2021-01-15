package com.build.policy.api;


import com.build.policy.core.CustomerCore;
import com.build.policy.dto.CreateCustomerRequest;
import com.build.policy.dto.UpdateCustomerRequest;
import com.build.policy.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Api(value = "Customers")
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerCore customerCore;

    @Autowired
    public CustomerController(CustomerCore customerCore) {
        this.customerCore = customerCore;
    }

    @ApiOperation(value="Create a new customer")
    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody CreateCustomerRequest createCustomer) {
        Customer customer = this.customerCore.save(createCustomer);
        return new ResponseEntity(customer, HttpStatus.CREATED);
    }

    @ApiOperation(value="Update a customer")
    @PutMapping("/{customerId}")
    public ResponseEntity update(@PathParam("customerId") String customerId,
                                 @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) throws Exception {
        Customer customer = this.customerCore.update(customerId, updateCustomerRequest);
        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @ApiOperation(value="Returns all customers")
    @GetMapping()
    public ResponseEntity findAll() {
        List<Customer> customers = this.customerCore.findAll();
        return new ResponseEntity(customers, HttpStatus.OK);
    }

    @ApiOperation(value="Returns a customer by id")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) throws Exception {
        Customer customer = this.customerCore.findById(id);
        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @ApiOperation(value="Delete a customer by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        this.customerCore.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
