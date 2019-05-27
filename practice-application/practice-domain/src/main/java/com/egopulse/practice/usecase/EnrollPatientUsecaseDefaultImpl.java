package com.egopulse.practice.usecase;

import com.egopulse.practice.api.EnrollPatientUsecase;
import com.egopulse.practice.api.model.MedicationPlan;
import com.egopulse.practice.api.model.Patient;
import com.egopulse.practice.usecase.utility.PatientValidator;
import com.egopulse.practice.usecase.utility.ValidationResult;
import io.reactivex.Observable;
import io.reactivex.Single;

public class EnrollPatientUsecaseDefaultImpl implements EnrollPatientUsecase {


    @Override
    public Single<Patient> enrollPatientByDoctor(Patient patient, MedicationPlan medicationPlan) {

        // validate patient info
        ValidationResult patientValidateResult = PatientValidator.validate(patient);

        if (patientValidateResult.getViolations() != null
                && patientValidateResult.getViolations().size() > 0) {
            Single<String> msg = Observable.fromIterable(patientValidateResult.getViolations())
                    .map(violation -> violation.getMessage())
                    .collect(StringBuilder::new, (sb, s) -> sb.append(", " + s)).map(sb -> sb.toString());
            return Single.error(new RuntimeException(msg.blockingGet()));
        }

        // validate medication plan


        // create patient profile


        // create practice-patient relationship

        // create medication plan
        // resolve detail
        // store medication detail


        // create chat room

        // notify patient


        return Single.just(patient);
    }
}
