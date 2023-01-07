package com.loofi.kyc.controller;

import com.loofi.kyc.entity.CustomerKyc;
import com.loofi.kyc.repository.CustomerKycRepository;
import com.loofi.kyc.service.CustomerKycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customerkyc")
public class CustomerKyController {

    @Autowired
    private CustomerKycService customerKycService;

    @Autowired
    private CustomerKycRepository customerKycRepository;

    @PostMapping()
    Long saveRegistration(@RequestBody CustomerKyc customerKyc){
        customerKyc.setId(null);
        Long CustomerKycId = customerKycService.saveRegistration(customerKyc);
        return CustomerKycId;
    }
    @PostMapping("/multiple")
    List<Long> saveMultipleRegistration(@RequestBody List<CustomerKyc> customerKycList){
        List<Long> idList = customerKycService.saveMultipleRegistration(customerKycList);
        return idList;
    }
    @GetMapping("/idNumber/{idNumber}")
    boolean checkUniqueIdNumber(@PathVariable(value = "idNumber") String idNumber){
        return customerKycRepository.existsByIdNumber(idNumber);
    }
}
