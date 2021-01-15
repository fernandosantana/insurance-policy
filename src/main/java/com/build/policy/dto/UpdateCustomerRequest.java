package com.build.policy.dto;

import com.build.policy.validations.CPFAlreadyExists;
import com.build.policy.validations.CustomerCPFValidationGroup;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;

@GroupSequence({UpdateCustomerRequest.class, CustomerCPFValidationGroup.class})
public class UpdateCustomerRequest {

    @NotEmpty(message = "CPF cannot be empty")
    @CPF(message = "CPF is invalid")
    @CPFAlreadyExists(groups = CustomerCPFValidationGroup.class)
    private String cpf = "";

    @NotEmpty(message = "Name cannot be empty")
    private String name = "";

    @NotEmpty(message = "Name cannot be empty")
    private String city = "";

    @NotEmpty(message = "Name cannot be empty")
    private String uf = "";

    public UpdateCustomerRequest() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
