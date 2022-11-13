package com.loofi.kyc.entity;

import com.loofi.kyc.model.enums.IdType;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer_kyc",
  indexes = {@Index(name = "idx_customer_unique_id", columnList = "customer_id", unique = true)})

public class CustomerKyc {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;
  private String idNumber; // NID, passport, driving licence
  @Enumerated(EnumType.STRING)
  private IdType idType;

  private String customerId;
  private String mobileNo;
  private String email;

  private String area;
  private String region;
  private String territory;

  private String presentAddress;
  private String presentCity;
  private String presentUnion;
  private String presentThana;
  private String presentDistrict;
  private String presentCountry;

  private String permanentAddress;
  private String permanentCity;
  private String permanentUnion;
  private String permanentThana;
  private String permanentDistrict;
  private String permanentCountry;

  private String nomineeName;
  private String nomineeMobile;
  private String nomineeIdNumber;
  @Enumerated(EnumType.STRING)
  private IdType nomineeIdType;
  private String nomineeAddress;
  private String nomineeRelation;

  private Instant createdDate;
  private Instant lastModifiedDate;

  private String createdBy;
  private String lastModifiedBy;
}
