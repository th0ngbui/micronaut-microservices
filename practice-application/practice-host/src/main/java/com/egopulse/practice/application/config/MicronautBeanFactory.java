package com.egopulse.practice.application.config;

import com.egopulse.practice.api.EnrollPatientUsecase;
import com.egopulse.practice.usecase.EnrollPatientUsecaseDefaultImpl;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class MicronautBeanFactory {

    @Singleton
    EnrollPatientUsecase enrollPatientUsecase() {
        return new EnrollPatientUsecaseDefaultImpl();
    }
}
