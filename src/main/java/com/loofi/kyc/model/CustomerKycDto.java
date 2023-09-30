package com.loofi.kyc.model;


import com.loofi.kyc.model.enums.IdType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@ToString
@Getter
@Setter
public class CustomerKycDto {
    private String identifier;
    private String firstName;
    private String idNumber;

    @Enumerated(EnumType.STRING)
    private IdType idType;
    private String email;
    private String credential;
}
