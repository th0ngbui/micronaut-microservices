package com.egopulse.profile.service.controller;

import com.egopulse.profile.api.ProfileUsecase;
import com.egopulse.profile.api.model.UserProfile;
import com.egopulse.profile.service.config.LoggerConfiguration;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Controller("/profile")
public class ProfileController implements ProfileUsecase {

    private static final Logger log = LoggerFactory.getLogger(ProfileController.class);

    @Inject
    ProfileUsecase profileUsecase;

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Single<UserProfile> enrollUser(@Body UserProfile userProfile) {
        return profileUsecase.enrollUser(userProfile);
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Observable users() {
        log.info("Get all users >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return profileUsecase.users();
    }
}
