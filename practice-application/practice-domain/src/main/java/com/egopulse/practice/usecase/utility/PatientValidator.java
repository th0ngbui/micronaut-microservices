package com.egopulse.practice.usecase.utility;

import com.egopulse.practice.api.model.Patient;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class PatientValidator {

    public static ValidationResult validate(Patient patient) {

        ValidationResult validationResult = ValidationResult.builder().violations(new ArrayList<>()).build();
        if (StringUtils.isEmpty(patient.getEmail())) {
            validationResult.violations.add(Violation.builder().message("Email is empty").build());
        }
        if (StringUtils.isEmpty(patient.getInsuranceNumber())) {
            validationResult.violations.add(Violation.builder().message("Insurance Number is empty").build());
        }
        return validationResult;
    }
}
