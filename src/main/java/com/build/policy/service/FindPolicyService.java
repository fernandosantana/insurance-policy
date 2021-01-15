package com.build.policy.service;

import com.build.policy.exception.NotFoundException;
import com.build.policy.model.Policy;
import com.build.policy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindPolicyService {

    private PolicyRepository policyRepository;

    @Autowired
    public FindPolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> findAll() {
        return this.policyRepository.findAll();
    }

    public Policy findById(String id) throws NotFoundException {
        Optional<Policy> optionalPolicy = this.policyRepository.findById(id);

        if(!optionalPolicy.isPresent()) {
            throw new NotFoundException("Policy not found");
        }
        return optionalPolicy.get();
    }

    public Policy findByNumber(Long number) throws NotFoundException {
        Optional<Policy> optionalPolicy = this.policyRepository.findByNumber(number);
        if(!optionalPolicy.isPresent()) {
            throw new NotFoundException("Policy not found");
        }

        return optionalPolicy.get();
    }
}
