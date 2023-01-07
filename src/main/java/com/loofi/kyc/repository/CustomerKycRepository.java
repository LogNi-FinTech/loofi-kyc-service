package com.loofi.kyc.repository;

import com.loofi.kyc.entity.CustomerKyc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerKycRepository extends JpaRepository<CustomerKyc, Integer> {
    Boolean existsByIdNumber(String idNumber);

    Optional<CustomerKyc> findByIdNumber(String idNumber);
}
