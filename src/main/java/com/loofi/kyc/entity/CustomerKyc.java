package com.loofi.kyc.entity;

import com.loofi.kyc.model.enums.IdType;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_kyc")
@ToString
@Getter
@Setter
public class CustomerKyc {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String idNumber; // NID, passport, driving licence
  @Enumerated(EnumType.STRING)
  private IdType idType;

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

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "CustomerKyc{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", idNumber='" + idNumber + '\'' +
            ", idType=" + idType +
            ", mobileNo='" + mobileNo + '\'' +
            ", email='" + email + '\'' +
            ", area='" + area + '\'' +
            ", region='" + region + '\'' +
            ", territory='" + territory + '\'' +
            ", presentAddress='" + presentAddress + '\'' +
            ", presentCity='" + presentCity + '\'' +
            ", presentUnion='" + presentUnion + '\'' +
            ", presentThana='" + presentThana + '\'' +
            ", presentDistrict='" + presentDistrict + '\'' +
            ", presentCountry='" + presentCountry + '\'' +
            ", permanentAddress='" + permanentAddress + '\'' +
            ", permanentCity='" + permanentCity + '\'' +
            ", permanentUnion='" + permanentUnion + '\'' +
            ", permanentThana='" + permanentThana + '\'' +
            ", permanentDistrict='" + permanentDistrict + '\'' +
            ", permanentCountry='" + permanentCountry + '\'' +
            ", nomineeName='" + nomineeName + '\'' +
            ", nomineeMobile='" + nomineeMobile + '\'' +
            ", nomineeIdNumber='" + nomineeIdNumber + '\'' +
            ", nomineeIdType=" + nomineeIdType +
            ", nomineeAddress='" + nomineeAddress + '\'' +
            ", nomineeRelation='" + nomineeRelation + '\'' +
            ", createdBy='" + createdBy + '\'' +
            ", lastModifiedBy='" + lastModifiedBy + '\'' +
            '}';
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public IdType getIdType() {
    return idType;
  }

  public void setIdType(IdType idType) {
    this.idType = idType;
  }

  public String getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getTerritory() {
    return territory;
  }

  public void setTerritory(String territory) {
    this.territory = territory;
  }

  public String getPresentAddress() {
    return presentAddress;
  }

  public void setPresentAddress(String presentAddress) {
    this.presentAddress = presentAddress;
  }

  public String getPresentCity() {
    return presentCity;
  }

  public void setPresentCity(String presentCity) {
    this.presentCity = presentCity;
  }

  public String getPresentUnion() {
    return presentUnion;
  }

  public void setPresentUnion(String presentUnion) {
    this.presentUnion = presentUnion;
  }

  public String getPresentThana() {
    return presentThana;
  }

  public void setPresentThana(String presentThana) {
    this.presentThana = presentThana;
  }

  public String getPresentDistrict() {
    return presentDistrict;
  }

  public void setPresentDistrict(String presentDistrict) {
    this.presentDistrict = presentDistrict;
  }

  public String getPresentCountry() {
    return presentCountry;
  }

  public void setPresentCountry(String presentCountry) {
    this.presentCountry = presentCountry;
  }

  public String getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(String permanentAddress) {
    this.permanentAddress = permanentAddress;
  }

  public String getPermanentCity() {
    return permanentCity;
  }

  public void setPermanentCity(String permanentCity) {
    this.permanentCity = permanentCity;
  }

  public String getPermanentUnion() {
    return permanentUnion;
  }

  public void setPermanentUnion(String permanentUnion) {
    this.permanentUnion = permanentUnion;
  }

  public String getPermanentThana() {
    return permanentThana;
  }

  public void setPermanentThana(String permanentThana) {
    this.permanentThana = permanentThana;
  }

  public String getPermanentDistrict() {
    return permanentDistrict;
  }

  public void setPermanentDistrict(String permanentDistrict) {
    this.permanentDistrict = permanentDistrict;
  }

  public String getPermanentCountry() {
    return permanentCountry;
  }

  public void setPermanentCountry(String permanentCountry) {
    this.permanentCountry = permanentCountry;
  }

  public String getNomineeName() {
    return nomineeName;
  }

  public void setNomineeName(String nomineeName) {
    this.nomineeName = nomineeName;
  }

  public String getNomineeMobile() {
    return nomineeMobile;
  }

  public void setNomineeMobile(String nomineeMobile) {
    this.nomineeMobile = nomineeMobile;
  }

  public String getNomineeIdNumber() {
    return nomineeIdNumber;
  }

  public void setNomineeIdNumber(String nomineeIdNumber) {
    this.nomineeIdNumber = nomineeIdNumber;
  }

  public IdType getNomineeIdType() {
    return nomineeIdType;
  }

  public void setNomineeIdType(IdType nomineeIdType) {
    this.nomineeIdType = nomineeIdType;
  }

  public String getNomineeAddress() {
    return nomineeAddress;
  }

  public void setNomineeAddress(String nomineeAddress) {
    this.nomineeAddress = nomineeAddress;
  }

  public String getNomineeRelation() {
    return nomineeRelation;
  }

  public void setNomineeRelation(String nomineeRelation) {
    this.nomineeRelation = nomineeRelation;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }
}
