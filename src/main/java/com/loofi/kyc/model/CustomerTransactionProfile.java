package com.loofi.kyc.model;

import com.loofi.kyc.entity.CustomerKyc;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class CustomerTransactionProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "customer_kyc_ic")
  private CustomerKyc customerKyc;

  private BigDecimal monthlyAverageBalance;
  private BigDecimal maxBalance;
  private BigDecimal maxTxnAmount;


}
