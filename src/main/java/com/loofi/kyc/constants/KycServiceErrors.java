package com.loofi.kyc.constants;

import java.util.HashMap;
import java.util.Map;

public class KycServiceErrors {
    // component code
    public static final String KYC_SERVICE = "12";
    // feature code
    public static final String KYC_MANAGEMENT = "001";
    // error code
    public static final String ACCOUNT_NOT_FOUND = "001";
    public static final String ID_NUMBER_ALREADY_EXIST = "002";
    public static final String USERNAME_ALREADY_EXIST = "003";
    public static final String PASSWORD_VALIDATION_FAILED = "007";
    public static final String INVALID_INPUT = "004";
    public static final String INTERNAL_ERROR = "005";
    public static final String REGISTRATION_USER_NOT_FOUND = "008";
    // Error mapping
    public static final Map<String, String> ERROR_MAP = new HashMap<String, String>();

    static {
        ERROR_MAP.put(ACCOUNT_NOT_FOUND, "Account Not Found");
        ERROR_MAP.put(INVALID_INPUT, "Invalid Input.");
        ERROR_MAP.put(ID_NUMBER_ALREADY_EXIST, "IdNumber Already Exist");
        ERROR_MAP.put(USERNAME_ALREADY_EXIST, "Username Already Exist");
        ERROR_MAP.put(INTERNAL_ERROR, "Something went wrong.");
        ERROR_MAP.put(PASSWORD_VALIDATION_FAILED, "Password validation failed.");
        ERROR_MAP.put(REGISTRATION_USER_NOT_FOUND, "Registration user not found.");
    }
    public static String getErrorCode(String featureCode,String errorCode){
        return KycServiceErrors.KYC_SERVICE + featureCode + errorCode;
    }
}
