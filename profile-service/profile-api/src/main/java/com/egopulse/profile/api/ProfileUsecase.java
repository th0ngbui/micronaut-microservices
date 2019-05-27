package com.egopulse.profile.api;

import com.egopulse.profile.api.model.UserProfile;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface ProfileUsecase {

    Single<UserProfile> enrollUser(UserProfile userProfile);

    Observable users();
}
