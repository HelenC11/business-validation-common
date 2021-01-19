package com.mservicetech.business.validation.sample;

import com.mservicetech.business.validation.BaseValidator;
import com.mservicetech.business.validation.ValidationCode;
import com.mservicetech.business.validation.ValidationResult;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class NBLicenseValidator  implements BaseValidator<String, DrivingLicense> {

    public  final String PATTERN_NB_LICENSE = "[0-9]{5,7}";
    public  final String LICENSE_FILTER = "NB";

    @Override
    public boolean support(String filter) {
        return LICENSE_FILTER.equalsIgnoreCase(filter);
    }

    @Override
    public Stream<ValidationResult> validate(Object context, DrivingLicense payload) {
        List<ValidationResult> validationResults  = new ArrayList<>();
        ValidationResult validationResult = new ValidationResult(NBLicenseValidator.class);
        Pattern.compile(PATTERN_NB_LICENSE);
        if (StringUtils.isBlank(payload.getDrivingLicenseNumber()) || !payload.getDrivingLicenseNumber().matches(PATTERN_NB_LICENSE))
        {
            validationResult.setError(true);
            validationResult.addValidationCodes(new ValidationCode("1101", "Invalid driving license number"));
        }
        validationResults.add(validationResult);
        return validationResults.stream();
    }
}
