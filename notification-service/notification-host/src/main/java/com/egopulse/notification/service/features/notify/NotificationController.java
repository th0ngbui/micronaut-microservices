package com.egopulse.notification.service.features.notify;

import com.egopulse.notification.api.NotificationUsecase;
import com.egopulse.notification.api.dto.NotificationRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("/notify")
public class NotificationController implements NotificationUsecase {

    @Inject
    NotificationUsecase notificationUsecase;

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Single<Boolean> notify(@Body NotificationRequest notificationRequest) {
        return notificationUsecase.notify(notificationRequest);
    }

}
