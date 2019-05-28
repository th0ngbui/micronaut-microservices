package com.egopulse.profile.usecase;

import com.egopulse.profile.api.ProfileUsecase;
import com.egopulse.profile.api.model.UserProfile;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProfileUsecaseDefaultImpl implements ProfileUsecase {

    List<UserProfile> userProfiles = new ArrayList<>();

    @Override
    public Single<UserProfile> enrollUser(UserProfile userProfile) {

        if (StringUtils.isEmpty(userProfile.getName())) {
            return Single.error(new RuntimeException("Name cannot be emtpy"));
        }

        String generatedId = UUID.randomUUID().toString();
        userProfile.setId(generatedId);

        userProfiles.add(userProfile);
        return Single.just(userProfile);
    }

    @Override
    public Observable users() {
        return Observable.fromArray(userProfiles.toArray());
    }
}
