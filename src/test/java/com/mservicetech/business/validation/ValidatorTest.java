package com.mservicetech.business.validation;

import com.mservicetech.business.validation.exception.BusinessValidationException;
import com.mservicetech.business.validation.sample.ABLicenseValidator;
import com.mservicetech.business.validation.sample.DrivingLicense;
import com.mservicetech.business.validation.sample.NBLicenseValidator;
import com.mservicetech.business.validation.sample.ONLicenseValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ValidatorTest {

    List<BaseValidator> validators;
    private DrivingLicense drivingLicense;

    @Before
    public  void setUp() {
        drivingLicense = new DrivingLicense();
        drivingLicense.setPlaceOfIssue("ON");
        drivingLicense.setDrivingLicenseNumber("N0926-63808-10125");
        BaseValidator onValidator = new ONLicenseValidator();
        BaseValidator abValidator = new ABLicenseValidator();
        BaseValidator nbValidator = new NBLicenseValidator();
        validators = new ArrayList<>();
        validators.add(onValidator);
        validators.add(abValidator);
        validators.add(nbValidator);
    }

    @Test
    public void testONLicenseValid() {
        List<ValidationCode> codes = new ArrayList<>();
        Stream<ValidationResult> validationResultStream = validators.stream().filter(validator->validator.support(drivingLicense.getPlaceOfIssue())).flatMap(v->v.validate(null,drivingLicense));
        validationResultStream.filter(v->v.isError()).forEach(v->codes.addAll(v.getValidationCodes()));
        Assert.assertEquals( codes.size(), 0);
    }

    @Test (expected = BusinessValidationException.class)
    public void testONLicenseInValid() {
        drivingLicense.setDrivingLicenseNumber("N0926-6380810125");
        List<ValidationCode> codes = new ArrayList<>();
        Stream<ValidationResult> validationResultStream = validators.stream().filter(validator->validator.support(drivingLicense.getPlaceOfIssue())).flatMap(v->v.validate(null,drivingLicense));
        validationResultStream.filter(v->v.isError()).forEach(v->codes.addAll(v.getValidationCodes()));
        Assert.assertTrue( codes.size()>0);
        if (codes.size()>0) {
            String errMsg = "Business validation error:" + ValidationResultUtil.getValidationMessage(codes);
         //   System.out.println(errMsg);
            throw new BusinessValidationException("Error", errMsg);
        }
    }

    @Test
    public void testABLicenseValid() {
        drivingLicense.setPlaceOfIssue("AB");
        drivingLicense.setDrivingLicenseNumber("933233-335");
        List<ValidationCode> codes = new ArrayList<>();
        Stream<ValidationResult> validationResultStream = validators.stream().filter(validator->validator.support(drivingLicense.getPlaceOfIssue())).flatMap(v->v.validate(null,drivingLicense));
        validationResultStream.filter(v->v.isError()).forEach(v->codes.addAll(v.getValidationCodes()));
        Assert.assertEquals( codes.size(), 0);
    }

    @Test (expected = BusinessValidationException.class)
    public void testABLicenseInValid() {
        drivingLicense.setPlaceOfIssue("AB");
        drivingLicense.setDrivingLicenseNumber("933233335");
        List<ValidationCode> codes = new ArrayList<>();
        Stream<ValidationResult> validationResultStream = validators.stream().filter(validator->validator.support(drivingLicense.getPlaceOfIssue())).flatMap(v->v.validate(null,drivingLicense));
        validationResultStream.filter(v->v.isError()).forEach(v->codes.addAll(v.getValidationCodes()));
        Assert.assertTrue( codes.size()>0);
        if (codes.size()>0) {
            String errMsg = "Business validation error:" + ValidationResultUtil.getValidationMessage(codes);
            throw new BusinessValidationException("Error", errMsg);
        }
    }

    @Test
    public void testNBLicenseValid() {
        drivingLicense.setPlaceOfIssue("NB");
        drivingLicense.setDrivingLicenseNumber("933233");
        List<ValidationCode> codes = new ArrayList<>();
        Stream<ValidationResult> validationResultStream = validators.stream().filter(validator->validator.support(drivingLicense.getPlaceOfIssue())).flatMap(v->v.validate(null,drivingLicense));
        validationResultStream.filter(v->v.isError()).forEach(v->codes.addAll(v.getValidationCodes()));
        Assert.assertEquals( codes.size(), 0);
    }
}
