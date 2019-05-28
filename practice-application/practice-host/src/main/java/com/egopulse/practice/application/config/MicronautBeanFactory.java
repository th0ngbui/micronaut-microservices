package com.egopulse.practice.application.config;

import com.egopulse.practice.api.EnrollPatientUsecase;
import com.egopulse.practice.application.client.NotificationClient;
import com.egopulse.practice.application.client.ProfileClient;
import com.egopulse.practice.usecase.EnrollPatientUsecaseDefaultImpl;
import io.micronaut.context.annotation.Factory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Factory
public class MicronautBeanFactory {

    @Inject
    ProfileClient profileClient;

    @Inject
    NotificationClient notificationClient;

    @Singleton
    EnrollPatientUsecase enrollPatientUsecase() {
        return new EnrollPatientUsecaseDefaultImpl(profileClient, notificationClient);
    }
}
