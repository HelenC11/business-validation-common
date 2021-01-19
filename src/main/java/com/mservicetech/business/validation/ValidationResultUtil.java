package com.mservicetech.business.validation;

import java.util.List;

public class ValidationResultUtil {

    public static String getValidationMessage (List<ValidationCode> validationCodes) {
        StringBuilder validationMessage = new StringBuilder();
        if (validationCodes!=null && validationCodes.size()>0) {
            validationCodes.stream().forEach(v-> validationMessage.append("Code:").append(v.getCode()).append(" - ").append("Message").append(v.getMessage()).append("; "));
        }
        return validationMessage.toString();
    }
}
