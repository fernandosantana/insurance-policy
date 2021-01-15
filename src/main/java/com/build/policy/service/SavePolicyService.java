package com.build.policy.service;

import com.build.policy.model.Policy;
import com.build.policy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePolicyService {

    private PolicyRepository policyRepository;

    @Autowired
    public SavePolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public Policy save(Policy policy) {
        return this.policyRepository.save(policy);
    }
}
