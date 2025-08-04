package com.pm.patient_service.DTO;

import com.pm.patient_service.DTO.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank(message = "Name is Required")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "Email is Required")
    @Email(message = "email should be valid")
    private String email;

    @NotBlank(message = "address is Required")
    private String address;

    @NotBlank(message = "Date Of birth is Required")
    private String dateOfBirth;

//    This is a private String field named registeredDate that must not be blank when creating a patient (CreatePatientValidationGroup).
//If it's left empty or contains only spaces, the error message "Registered date is Required" will be shown.
    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Registered date is Required")
    private String registeredDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
