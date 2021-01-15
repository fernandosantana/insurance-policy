package com.build.policy.core;

import com.build.policy.dto.CreatePolicyRequest;
import com.build.policy.dto.UpdatePolicyRequest;
import com.build.policy.model.Customer;
import com.build.policy.model.Policy;
import com.build.policy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyCore {

    private FindPolicyService findPolicyService;
    private FindCustomerService findCustomerService;
    private SavePolicyService savePolicyService;
    private DeletePolicyService deletePolicyService;
    private BuildPolicyService buildPolicyService;
    private GeneratePolicyNumberService generatePolicyNumber;

    @Autowired
    public PolicyCore(FindPolicyService findPolicyService, FindCustomerService findCustomerService,
                      SavePolicyService savePolicyService, DeletePolicyService deletePolicyService,
                      BuildPolicyService buildPolicyService, GeneratePolicyNumberService generatePolicyNumber) {
        this.findPolicyService = findPolicyService;
        this.findCustomerService = findCustomerService;
        this.savePolicyService = savePolicyService;
        this.deletePolicyService = deletePolicyService;
        this.buildPolicyService = buildPolicyService;
        this.generatePolicyNumber = generatePolicyNumber;
    }

    public Policy create(CreatePolicyRequest createPolicy) throws Exception {
        Customer customer = this.findCustomerService.findById(createPolicy.getCustomerId());
        Long policyNumber = this.generatePolicyNumber.generateNewNumber();

        Policy policy = this.buildPolicyService.create(createPolicy, customer, policyNumber);
        return this.savePolicyService.save(policy);
    }

    public Policy update(String policyId, UpdatePolicyRequest updatePolicyRequest) throws Exception {
        Policy policy = this.findPolicyService.findById(policyId);
        Customer customer = this.findCustomerService.findById(updatePolicyRequest.getCustomerId());

        Policy updatedfPolicy = this.buildPolicyService.update(policy, customer, updatePolicyRequest);
        return this.savePolicyService.save(updatedfPolicy);
    }

    public List<Policy> findAll() {
        List<Policy> policies = this.findPolicyService.findAll();
        return policies.stream().map(policy -> this.buildPolicyService.updateExpireDate(policy)).collect(Collectors.toList());
    }

    public Policy findById(String id) throws Exception {
        return this.findPolicyService.findById(id);
    }

    public Policy findByNumber(Long number) throws Exception {
        return this.findPolicyService.findByNumber(number);
    }

    public void deleteById(String id) {
        this.deletePolicyService.deleteById(id);
    }

}
