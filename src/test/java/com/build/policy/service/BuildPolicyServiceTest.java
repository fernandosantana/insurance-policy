package com.build.policy.service;

import com.build.policy.dto.CreatePolicyRequest;
import com.build.policy.dto.UpdatePolicyRequest;
import com.build.policy.model.Customer;
import com.build.policy.model.Policy;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;


public class BuildPolicyServiceTest {

    @Test
    void mustCreatePolicyNotExpired() {
        Long policyNumber = 1l;
        Customer customer = new Customer();
        customer.setName("Test Name");

        LocalDate initialDate = LocalDate.now().minusMonths(6);
        LocalDate finalDate = LocalDate.now().plusMonths(6);

        Long days = ChronoUnit.DAYS.between(LocalDate.now(), finalDate);

        CreatePolicyRequest createPolicy = new CreatePolicyRequest();
        createPolicy.setInitalDate(initialDate);
        createPolicy.setFinalDate(finalDate);

        BuildPolicyService buildService = new BuildPolicyService();

        Policy policy = buildService.create(createPolicy, customer, policyNumber);

        assertNotNull(policy);
        assertNotNull(policy.getCustomer());
        assertEquals(policyNumber, policy.getNumber());
        assertEquals(customer.getName(), policy.getCustomer().getName());
        assertEquals(createPolicy.getInitalDate(), policy.getInitalDate());
        assertEquals(createPolicy.getFinalDate(), policy.getFinalDate());
        assertFalse(policy.isHasExpired());
        assertEquals(days.intValue(), policy.getDaysToExpire());
    }

    @Test
    void mustCreatePolicyExpired() {
        Long policyNumber = 1l;
        Customer customer = new Customer();
        customer.setName("Test Name");

        LocalDate initialDate = LocalDate.now().minusMonths(6);
        LocalDate finalDate = LocalDate.now().minusMonths(1);

        Long days = ChronoUnit.DAYS.between(LocalDate.now(), finalDate);

        CreatePolicyRequest createPolicy = new CreatePolicyRequest();
        createPolicy.setInitalDate(initialDate);
        createPolicy.setFinalDate(finalDate);

        BuildPolicyService buildService = new BuildPolicyService();

        Policy policy = buildService.create(createPolicy, customer, policyNumber);

        assertNotNull(policy);
        assertNotNull(policy.getCustomer());
        assertEquals(policyNumber, policy.getNumber());
        assertEquals(customer.getName(), policy.getCustomer().getName());
        assertEquals(createPolicy.getInitalDate(), policy.getInitalDate());
        assertEquals(createPolicy.getFinalDate(), policy.getFinalDate());
        assertTrue(policy.isHasExpired());
        assertEquals(days.intValue(), policy.getDaysToExpire());
    }

    @Test
    void mustUpdatePolicyNotExpired() {
        Long policyNumber = 1l;
        Customer oldCustomer = new Customer();
        oldCustomer.setName("Test Old Name");

        Policy oldPolicy = new Policy();
        oldPolicy.setId("id");
        oldPolicy.setNumber(policyNumber);
        oldPolicy.setInitalDate(LocalDate.now());
        oldPolicy.setFinalDate(LocalDate.now().plusMonths(2));
        oldPolicy.setCustomer(oldCustomer);

        Customer customer = new Customer();
        customer.setName("Test new Name");

        LocalDate initialDate = LocalDate.now().minusMonths(6);
        LocalDate finalDate = LocalDate.now().plusMonths(6);

        Long days = ChronoUnit.DAYS.between(LocalDate.now(), finalDate);

        UpdatePolicyRequest updatePolicy = new UpdatePolicyRequest();
        updatePolicy.setInitalDate(initialDate);
        updatePolicy.setFinalDate(finalDate);

        BuildPolicyService buildService = new BuildPolicyService();

        Policy policy = buildService.update(oldPolicy, customer, updatePolicy);

        assertNotNull(policy);
        assertNotNull(policy.getCustomer());
        assertEquals(policyNumber, policy.getNumber());
        assertEquals(customer.getName(), policy.getCustomer().getName());
        assertEquals(updatePolicy.getInitalDate(), policy.getInitalDate());
        assertEquals(updatePolicy.getFinalDate(), policy.getFinalDate());
        assertFalse(policy.isHasExpired());
        assertEquals(days.intValue(), policy.getDaysToExpire());
    }

    @Test
    void mustUpdatePolicyExpired() {
        Long policyNumber = 1l;
        Customer oldCustomer = new Customer();
        oldCustomer.setName("Test Old Name");

        Policy oldPolicy = new Policy();
        oldPolicy.setId("id");
        oldPolicy.setNumber(policyNumber);
        oldPolicy.setInitalDate(LocalDate.now());
        oldPolicy.setFinalDate(LocalDate.now().plusMonths(2));
        oldPolicy.setCustomer(oldCustomer);

        Customer customer = new Customer();
        customer.setName("Test new Name");

        LocalDate initialDate = LocalDate.now().minusMonths(6);
        LocalDate finalDate = LocalDate.now().minusMonths(1);

        Long days = ChronoUnit.DAYS.between(LocalDate.now(), finalDate);

        UpdatePolicyRequest updatePolicy = new UpdatePolicyRequest();
        updatePolicy.setInitalDate(initialDate);
        updatePolicy.setFinalDate(finalDate);

        BuildPolicyService buildService = new BuildPolicyService();

        Policy policy = buildService.update(oldPolicy, customer, updatePolicy);

        assertNotNull(policy);
        assertNotNull(policy.getCustomer());
        assertEquals(policyNumber, policy.getNumber());
        assertEquals(customer.getName(), policy.getCustomer().getName());
        assertEquals(updatePolicy.getInitalDate(), policy.getInitalDate());
        assertEquals(updatePolicy.getFinalDate(), policy.getFinalDate());
        assertTrue(policy.isHasExpired());
        assertEquals(days.intValue(), policy.getDaysToExpire());
    }
}
