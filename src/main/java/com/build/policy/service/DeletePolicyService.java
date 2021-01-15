package com.build.policy.service;

import com.build.policy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePolicyService {

    private PolicyRepository policyRepository;

    @Autowired
    public DeletePolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public void deleteById(String id) {
        this.policyRepository.deleteById(id);
    }
}
