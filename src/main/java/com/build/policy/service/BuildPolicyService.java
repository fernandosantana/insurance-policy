package com.build.policy.service;

import com.build.policy.dto.CreatePolicyRequest;
import com.build.policy.dto.UpdatePolicyRequest;
import com.build.policy.model.Customer;
import com.build.policy.model.Policy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class BuildPolicyService {

    public Policy create(CreatePolicyRequest createPolicy, Customer customer, Long policyNumber) {
        Policy policy = new Policy();
        policy.setCustomer(customer);
        policy.setFinalDate(createPolicy.getFinalDate());
        policy.setInitalDate(createPolicy.getInitalDate());
        policy.setNumber(policyNumber);
        policy.setLicencePlate(createPolicy.getLicencePlate());
        policy.setPrice(createPolicy.getPrice());
        policy.setHasExpired(this.hasExpired(createPolicy.getFinalDate()));
        policy.setDaysToExpire(this.calculeDaysToExpire(createPolicy.getFinalDate()));

        return policy;
    }

    public Policy update(Policy policy, Customer customer, UpdatePolicyRequest updatePolicyRequest) {
        Policy updatedPolicy = new Policy();
        updatedPolicy.setNumber(policy.getNumber());
        updatedPolicy.setInitalDate(updatePolicyRequest.getInitalDate());
        updatedPolicy.setFinalDate(updatePolicyRequest.getFinalDate());
        updatedPolicy.setCustomer(customer);
        policy.setLicencePlate(updatePolicyRequest.getLicencePlate());
        policy.setPrice(updatePolicyRequest.getPrice());
        updatedPolicy.setHasExpired(this.hasExpired(updatePolicyRequest.getFinalDate()));
        updatedPolicy.setDaysToExpire(this.calculeDaysToExpire(updatePolicyRequest.getFinalDate()));

        return updatedPolicy;
    }

    public Policy updateExpireDate(Policy policy) {
        Policy updatedPolicy = new Policy();
        updatedPolicy.setId(policy.getId());
        updatedPolicy.setNumber(policy.getNumber());
        updatedPolicy.setInitalDate(policy.getInitalDate());
        updatedPolicy.setFinalDate(policy.getFinalDate());
        updatedPolicy.setCustomer(policy.getCustomer());
        updatedPolicy.setHasExpired(this.hasExpired(policy.getFinalDate()));
        updatedPolicy.setDaysToExpire(this.calculeDaysToExpire(policy.getFinalDate()));

        return updatedPolicy;
    }

    private boolean hasExpired(LocalDate finalDate) {
        return finalDate.isBefore(LocalDate.now());
    }

    private int calculeDaysToExpire(LocalDate finalDate) {
        Long days = ChronoUnit.DAYS.between(LocalDate.now(), finalDate);
        return days.intValue();
    }
}
