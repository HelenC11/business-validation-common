package com.mservicetech.business.validation.sample;

public class DrivingLicense {
    private String placeOfIssue;
    private String countryOfIssue;
    private String drivingLicenseNumber;

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    @Override
    public String toString() {
        return "DrivingLicense{" +
                "placeOfIssue='" + placeOfIssue + '\'' +
                ", countryOfIssue='" + countryOfIssue + '\'' +
                ", drivingLicenseNumber='" + drivingLicenseNumber + '\'' +
                '}';
    }
}
