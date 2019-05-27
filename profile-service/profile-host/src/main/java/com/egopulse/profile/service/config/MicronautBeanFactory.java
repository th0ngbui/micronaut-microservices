package com.egopulse.profile.service.config;

import com.egopulse.profile.api.ProfileUsecase;
import com.egopulse.profile.usecase.ProfileUsecaseDefaultImpl;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class MicronautBeanFactory {

    @Singleton
    ProfileUsecase profileUsecase() {
        return new ProfileUsecaseDefaultImpl();
    }
}
