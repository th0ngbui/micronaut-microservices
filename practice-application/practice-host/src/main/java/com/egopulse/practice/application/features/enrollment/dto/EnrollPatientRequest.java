package com.egopulse.practice.application.features.enrollment.dto;

import com.egopulse.practice.api.model.MedicationPlan;
import com.egopulse.practice.api.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollPatientRequest {
    private Patient patient;
    private MedicationPlan medicationPlan;
}
