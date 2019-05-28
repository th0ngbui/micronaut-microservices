package com.egopulse.practice.usecase;

import com.egopulse.practice.api.EnrollPatientUsecase;
import com.egopulse.practice.api.model.MedicationPlan;
import com.egopulse.practice.api.model.Patient;
import com.egopulse.practice.usecase.utility.PatientValidator;
import com.egopulse.practice.usecase.utility.ValidationResult;
import com.egopulse.profile.api.ProfileUsecase;
import com.egopulse.profile.api.model.UserProfile;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.dozer.DozerBeanMapper;

public class EnrollPatientUsecaseDefaultImpl implements EnrollPatientUsecase {

    ProfileUsecase profileUsecase;

    public EnrollPatientUsecaseDefaultImpl(ProfileUsecase profileUsecase) {
        this.profileUsecase = profileUsecase;
    }

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
        UserProfile userProfile = new DozerBeanMapper().map(patient, UserProfile.class);
        Single<UserProfile> userProfileSingle = profileUsecase.enrollUser(userProfile)
                .doOnError(err -> Single.error(err));

        // create practice-patient relationship

        // create medication plan
        // resolve detail
        // store medication detail


        // create chat room

        // notify patient


        return userProfileSingle.flatMap(response -> {
//            if(response.getStatus().getCode()!=200) {
//                return Single.error(new RuntimeException("Error"));
//            }
            return Single.just(patient);
        });

//        return Single.just(patient);
    }
}
