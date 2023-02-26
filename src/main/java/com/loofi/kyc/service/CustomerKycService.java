package com.loofi.kyc.service;


import com.loofi.kyc.entity.CustomerKyc;
import com.loofi.kyc.repository.CustomerKycRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerKycService {

    @Autowired
    private CustomerKycRepository customerKycRepository;

    public List<Long> saveMultipleRegistration(List<CustomerKyc> customerKycList) {
        List<Long> customerIdList = new ArrayList<>();
        for (CustomerKyc customerKyc : customerKycList){
            customerIdList.add(customerKycRepository.save(customerKyc).getId());
        }
        return customerIdList;
    }

    public Long saveRegistration(CustomerKyc customerKyc) {
        if(customerKyc.getIdNumber() != null && customerKycRepository.existsByIdNumber(customerKyc.getIdNumber())){
            return customerKycRepository.findByIdNumber(customerKyc.getIdNumber()).get().getId();
        }
        return customerKycRepository.save(customerKyc).getId();
    }
}
