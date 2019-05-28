package com.egopulse.practice.application.client;

import com.egopulse.notification.api.NotificationUsecase;
import com.egopulse.notification.api.dto.NotificationRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client(id = "notification-service", path = "/notify")
public interface NotificationClient extends NotificationUsecase {

    @Override
    @Post
    Single<Boolean> notify(@Body NotificationRequest notificationRequest);
}
