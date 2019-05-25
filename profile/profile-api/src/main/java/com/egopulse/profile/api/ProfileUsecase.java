package com.egopulse.profile.api;

import com.egopulse.profile.api.model.UserProfile;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface ProfileUsecase {

    @Post
    Single<UserProfile> enrollUser(UserProfile userProfile);

    @Get
    Observable users();
}
