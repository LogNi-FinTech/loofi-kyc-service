package com.loofi.kyc.controller;

import com.loofi.kyc.entity.CustomerKyc;
import com.loofi.kyc.repository.CustomerKycRepository;
import com.loofi.kyc.service.CustomerKycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customerkyc")
public class CustomerKyController {

    @Autowired
    private CustomerKycService customerKycService;

    @Autowired
    private CustomerKycRepository customerKycRepository;

    @PostMapping
    Long saveRegistration(@RequestBody CustomerKyc customerKyc){
        customerKyc.setId(null);
        Long CustomerKycId = customerKycService.saveRegistration(customerKyc);
        return CustomerKycId;
    }
    Long saveRegistrationByCustomer(@RequestBody CustomerKyc customerKyc){
        //customerKyc.setId(null);
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

    @GetMapping("/mobile/{mobileNo}")
    ResponseEntity<CustomerKyc> fetchCustomerByMobileNumber(@PathVariable(value = "mobileNo") String mobile){
        Optional<CustomerKyc> customerKyc = customerKycRepository.findByMobileNo(mobile);
        if(customerKyc.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(customerKyc.get());
        else
            return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<CustomerKyc> fetchCustomerById(@PathVariable(value = "id") Long id){
        Optional<CustomerKyc> customerKyc = customerKycRepository.findById(id);
        if(customerKyc.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(customerKyc.get());
        else
            return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @GetMapping
    ResponseEntity<List<CustomerKyc>> fetchCustomers(){
        List<CustomerKyc> customers = customerKycRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @DeleteMapping("/id/{id}")
    ResponseEntity<Integer> deleteCustomerById(@PathVariable(value = "id") Long id){
        if(customerKycRepository.existsById(id)){
            customerKycRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
