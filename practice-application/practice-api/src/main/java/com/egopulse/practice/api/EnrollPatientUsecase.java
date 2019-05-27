package com.egopulse.practice.api;

import com.egopulse.practice.api.model.MedicationPlan;
import com.egopulse.practice.api.model.Patient;
import io.reactivex.Single;

public interface EnrollPatientUsecase {

    Single<Patient> enrollPatientByDoctor(Patient patient, MedicationPlan medicationPlan);
}
