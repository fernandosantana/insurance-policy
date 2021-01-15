package com.build.policy.repository;

import com.build.policy.model.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PolicyRepository extends MongoRepository<Policy, String> {

    Optional<Policy> findByNumber(Long number);

    Optional<Policy> findTopByOrderByNumberDesc();
}
