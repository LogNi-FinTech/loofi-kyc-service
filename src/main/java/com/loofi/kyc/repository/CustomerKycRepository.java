package com.loofi.kyc.repository;

import com.loofi.kyc.entity.CustomerKyc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerKycRepository extends JpaRepository<CustomerKyc, Integer> {

}
