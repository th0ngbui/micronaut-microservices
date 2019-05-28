package com.egopulse.notification.service.config;

import com.egopulse.notification.api.NotificationUsecase;
import com.egopulse.notification.usecase.NotificationUsecaseDefaultImpl;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class MicronautBeanFactory {

    @Singleton
    NotificationUsecase notificationUsecase() {
        return new NotificationUsecaseDefaultImpl();
    }
}
