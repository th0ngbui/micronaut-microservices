package com.egopulse.practice.application.client;

import com.egopulse.profile.api.ProfileUsecase;
import com.egopulse.profile.api.model.UserProfile;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Observable;
import io.reactivex.Single;

@Client(id = "profile-service", path = "/profile")
public interface ProfileClient extends ProfileUsecase {

    @Override
    @Post
    Single<UserProfile> enrollUser(@Body UserProfile userProfile);

    @Override
    @Get
    Observable users();
}
