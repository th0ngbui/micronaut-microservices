package com.egopulse.practice.usecase;

import com.egopulse.notification.api.NotificationUsecase;
import com.egopulse.notification.api.dto.NotificationRequest;
import com.egopulse.notification.api.model.CommunicationChannel;
import com.egopulse.notification.api.model.Header;
import com.egopulse.notification.api.model.Message;
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

    private ProfileUsecase profileUsecase;

    private NotificationUsecase notificationUsecase;

    public EnrollPatientUsecaseDefaultImpl(ProfileUsecase profileUsecase, NotificationUsecase notificationUsecase) {
        this.profileUsecase = profileUsecase;
        this.notificationUsecase = notificationUsecase;
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
                .doOnError(err -> Single.error(err))
                .doOnSuccess(res -> {
                    // notify patient
                    Header header = Header.builder().name(patient.getName())
                            .email(patient.getEmail())
                            .build();
                    Message message = Message.builder().body("Successfully enroll patient").build();
                    CommunicationChannel communicationChannel = CommunicationChannel.builder().type(CommunicationChannel.Type.EMAIL).build();


                    NotificationRequest notificationRequest = NotificationRequest.builder()
                            .header(header)
                            .message(message)
                            .communicationChannel(communicationChannel)
                            .build();
                    notificationUsecase.notify(notificationRequest)
                            .doOnError(sendErr -> Single.error(sendErr))
                            .subscribe();
                });

        // create practice-patient relationship

        // create medication plan
        // resolve detail
        // store medication detail


        // create chat room


        return userProfileSingle.flatMap(response -> Single.just(patient));
    }
}
