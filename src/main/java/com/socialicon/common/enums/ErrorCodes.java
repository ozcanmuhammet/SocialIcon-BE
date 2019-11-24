package com.socialicon.common.enums;


public enum ErrorCodes {
    EMAIL_ALREADY_EXIST("1000", "This email address is already in use: "),
    EMAIL_NOT_VALID("1001", "Invalid email address: "),
    USER_NOT_FOUND("1008", "User not found: "),
    INVALID_USER("1009", "Invalid User: "),
    OFFER_NOT_FOUND("1100", "Offer not found: ");

    private String errorCode;
    private String errorMessage;

    ErrorCodes(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
