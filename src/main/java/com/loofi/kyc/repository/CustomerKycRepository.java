package com.loofi.kyc.repository;

import com.loofi.kyc.entity.CustomerKyc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerKycRepository extends JpaRepository<CustomerKyc, Integer> {
    Boolean existsByIdNumber(String idNumber);

    boolean existsById(Long id);

    Optional<CustomerKyc> findByMobileNo(String mobileNo);

    Optional<CustomerKyc> findByIdNumber(String idNumber);

    Optional<CustomerKyc> findById(Long id);

   void deleteById(Long id);
}
