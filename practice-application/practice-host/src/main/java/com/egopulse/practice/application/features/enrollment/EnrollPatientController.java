package com.egopulse.practice.application.features.enrollment;

import com.egopulse.practice.api.EnrollPatientUsecase;
import com.egopulse.practice.api.model.Patient;
import com.egopulse.practice.application.features.enrollment.dto.EnrollPatientRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("/enrollment")
public class EnrollPatientController {

    @Inject
    EnrollPatientUsecase enrollPatientUsecase;

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Single<Patient> enrollUser(@Body EnrollPatientRequest enrollPatientRequest) {

        Single<Patient> result = enrollPatientUsecase.enrollPatientByDoctor(enrollPatientRequest.getPatient(), enrollPatientRequest.getMedicationPlan());
        return result;
    }

}
