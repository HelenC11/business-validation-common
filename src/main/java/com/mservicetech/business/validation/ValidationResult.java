package com.mservicetech.business.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    boolean isError;
    Class<? extends BaseValidator> validatorClass;
    List<ValidationCode> validationCodes;

    public ValidationResult(Class<? extends BaseValidator> validatorClass) {
        isError = false;
        this.validatorClass = validatorClass;
        validationCodes = new ArrayList<>();
    }

    public Class<? extends BaseValidator> getValidatorClass() {
        return validatorClass;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public List<ValidationCode> getValidationCodes() {
        return validationCodes;
    }

    public void setValidationCodes(List<ValidationCode> validationCodes) {
        this.validationCodes = validationCodes;
    }

    public void addValidationCodes(ValidationCode validationCode) {
        this.validationCodes.add(validationCode);
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "isError=" + isError +
                ", validatorClass=" + validatorClass +
                ", validationCodes=" + validationCodes.toString() +
                '}';
    }
}
