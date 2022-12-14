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

    public List<Long> saveMultipleRegistration(List<CustomerKyc> customerKyc) {
        List<Long> customerIdList = new ArrayList<>();
        for (CustomerKyc cus : customerKyc){
            customerIdList.add(customerKycRepository.save(cus).getId());
        }
        return customerIdList;
    }
}
