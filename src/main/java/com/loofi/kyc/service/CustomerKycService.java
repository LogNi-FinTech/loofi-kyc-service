package com.loofi.kyc.service;


import com.loofi.kyc.constants.KycServiceErrors;
import com.loofi.kyc.entity.CustomerKyc;
import com.loofi.kyc.exceptions.CommonException;
import com.loofi.kyc.model.Customer;
import com.loofi.kyc.model.CustomerKycDto;
import com.loofi.kyc.model.enums.IdType;
import com.loofi.kyc.repository.CustomerKycRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerKycService {

    @Autowired
    private CustomerKycRepository customerKycRepository;

    private static RestTemplate restTemplate = new RestTemplate();

    @Value("${core.base.url:http://localhost:8091/}")
    private String authServiceBaseUrl;

    @Value("${auth.service.customer.role}")
    private String customerRole;

    @Value("${auth.service.customer.credentialType}")
    private String credentialType;

    @Value("${core.base.url:http://103.125.252.81:8080/account/}")
    private String accountServiceBaseUrl;

    public List<Long> saveMultipleRegistration(List<CustomerKyc> customerKycList) {
        List<Long> customerIdList = new ArrayList<>();
        for (CustomerKyc customerKyc : customerKycList) {
            customerIdList.add(customerKycRepository.save(customerKyc).getId());
        }
        return customerIdList;
    }

    public Long saveRegistration(CustomerKyc customerKyc) {
        if (customerKyc.getIdNumber() != null && customerKycRepository.existsByIdNumber(customerKyc.getIdNumber())) {
            return customerKycRepository.findByIdNumber(customerKyc.getIdNumber()).get().getId();
        }
        return customerKycRepository.save(customerKyc).getId();
    }

    public Long saveRegistrationByCustomer(CustomerKycDto customerKycdto) {
        if (customerKycdto.getIdNumber() != null && customerKycRepository.existsByIdNumber(customerKycdto.getIdNumber())) {
            throw new CommonException(
                    KycServiceErrors.getErrorCode(KycServiceErrors.KYC_SERVICE, KycServiceErrors.ID_NUMBER_ALREADY_EXIST),
                    KycServiceErrors.ERROR_MAP.get(KycServiceErrors.ID_NUMBER_ALREADY_EXIST));
        }

        saveCustomerOnAuthService(customerKycdto);
        Long customerId = customerKycRepository.save(getCustomerKycFromCustomerKycDto(customerKycdto)).getId();
        saveCustomerOnAccountService(getAccountServicePayload(customerKycdto, customerId));
        return customerId;
    }

    private void saveCustomerOnAuthService(CustomerKycDto customerKycdto) {
        HttpHeaders headers = new HttpHeaders();
        // headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> payload = getAuthServicePayload(customerKycdto);
        HttpEntity<Object> requestEntity = new HttpEntity<>(payload, headers);
        ResponseEntity<String> responseCustomerId = restTemplate.exchange(authServiceBaseUrl + "api/signup",
                HttpMethod.POST,
                requestEntity,
                String.class);
    }

    private Map<String, Object> getAuthServicePayload(CustomerKycDto customerKycdto) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("userIdentifier", customerKycdto.getIdentifier());
        payload.put("credential", customerKycdto.getCredential());
        payload.put("credentialType", credentialType);
        payload.put("wrongCredCount", 0);

        List<Map<String, String>> roles = new ArrayList<>();
        Map<String, String> role = new HashMap<>();
        role.put("name", customerRole);
        roles.add(role);

        payload.put("roles", roles);
        return payload;
    }

    private CustomerKyc getCustomerKycFromCustomerKycDto(CustomerKycDto customerKycDto){
        CustomerKyc customerKyc = new CustomerKyc();
        customerKyc.setFirstName(customerKycDto.getFirstName());
        customerKyc.setIdNumber(customerKycDto.getIdNumber());
        customerKyc.setIdType(customerKycDto.getIdType());
        customerKyc.setEmail(customerKycDto.getEmail());
        return customerKyc;
    }

    private void saveCustomerOnAccountService(Customer customer){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(customer, headers);
        ResponseEntity<Void> responseCustomerId = restTemplate.exchange(accountServiceBaseUrl + "api/v1/account/customer",
                HttpMethod.POST,
                requestEntity,
                Void.class);
    }

    private Customer getAccountServicePayload(CustomerKycDto customerKycDto, Long customerId){
        Customer customer = new Customer();
        customer.setName(customerKycDto.getFirstName());
        customer.setCustomerId(customerId.toString());
        customer.setIdentifier(customerKycDto.getIdentifier());
        customer.setState("ACTIVE");
        return customer;
    }

}
