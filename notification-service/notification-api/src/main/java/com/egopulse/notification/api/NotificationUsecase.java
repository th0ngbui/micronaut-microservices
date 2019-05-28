package com.egopulse.notification.api;

import com.egopulse.notification.api.dto.NotificationRequest;
import io.reactivex.Single;

public interface NotificationUsecase {

    Single<Boolean> notify(NotificationRequest notificationRequest);
}
