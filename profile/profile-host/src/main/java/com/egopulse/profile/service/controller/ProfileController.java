package com.egopulse.profile.service.controller;

import com.egopulse.profile.api.ProfileUsecase;
import com.egopulse.profile.api.model.UserProfile;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Observable;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("/profile")
public class ProfileController implements ProfileUsecase {

    @Inject
    ProfileUsecase profileUsecase;

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Single<UserProfile> enrollUser(@Body UserProfile userProfile) {
        profileUsecase.enrollUser(userProfile);
        return Single.just(userProfile);
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Observable users() {
        return profileUsecase.users();
    }
}
