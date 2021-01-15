package com.build.policy.api;

import com.build.policy.core.PolicyCore;
import com.build.policy.dto.CreatePolicyRequest;
import com.build.policy.dto.UpdatePolicyRequest;
import com.build.policy.model.Policy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Api(value = "Policies")
@RestController
@RequestMapping("/policies")
public class PolicyController {

    private PolicyCore policyCore;

    @Autowired
    public PolicyController(PolicyCore policyCore) {
        this.policyCore = policyCore;
    }

    @ApiOperation(value="Create a new policy")
    @PostMapping()
    public Policy save(@RequestBody CreatePolicyRequest createPolicy) throws Exception {
        return this.policyCore.create(createPolicy);
    }

    @ApiOperation(value="Update a policy")
    @PutMapping("/{policyId}")
    public Policy update(@PathParam("policyId") String policyId,
                         @Valid @RequestBody UpdatePolicyRequest updatePolicyRequest) throws Exception {
        return this.policyCore.update(policyId, updatePolicyRequest);
    }

    @ApiOperation(value="Returns all policies")
    @GetMapping()
    public List<Policy> findAll() {
        return this.policyCore.findAll();
    }

    @ApiOperation(value="Returns a policy by id")
    @GetMapping("/{id}")
    public Policy findById(@PathVariable("id") String id) throws Exception {
        return this.policyCore.findById(id);
    }

    @ApiOperation(value="Return a policy by number")
    @GetMapping("number/{number}")
    public Policy findByNumber(@PathVariable("number") Long number) throws Exception {
        return this.policyCore.findByNumber(number);
    }

    @ApiOperation(value="Delete a policy by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        this.policyCore.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
