package com.build.policy.service;

import com.build.policy.model.Policy;
import com.build.policy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneratePolicyNumberService {

    private PolicyRepository repository;

    @Autowired
    public GeneratePolicyNumberService(PolicyRepository repository) {
        this.repository = repository;
    }

    public long generateNewNumber() {
        Optional<Policy> optionalPolicy = this.repository.findTopByOrderByNumberDesc();

        if(optionalPolicy.isPresent()) {
            return optionalPolicy.get().getNumber() + 1;
        }

        return 1;
    }

}
