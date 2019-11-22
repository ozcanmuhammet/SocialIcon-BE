package com.socialicon.common.enums;


public enum ErrorCodes {
    USER_NOT_FOUND("1008", "User not found with email: ");



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
