package com.egopulse.notification.usecase;

import com.egopulse.notification.api.NotificationUsecase;
import com.egopulse.notification.api.dto.NotificationRequest;
import com.egopulse.notification.api.model.CommunicationChannel;
import com.egopulse.notification.api.model.Header;
import com.egopulse.notification.api.model.Message;
import io.reactivex.Single;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationUsecaseDefaultImpl implements NotificationUsecase {

    private static final Logger log = LoggerFactory.getLogger(NotificationUsecaseDefaultImpl.class);

    @Override
    public Single<Boolean> notify(NotificationRequest notificationRequest) {

        Header header = notificationRequest.getHeader();
        Message message = notificationRequest.getMessage();
        CommunicationChannel communicationChannel = notificationRequest.getCommunicationChannel();

        if (communicationChannel.getType() == CommunicationChannel.Type.EMAIL
                && StringUtils.isEmpty(header.getEmail())) {
            return Single.error(new RuntimeException("Email cannot be empty"));
        } else if (communicationChannel.getType() == CommunicationChannel.Type.SMS
                && StringUtils.isEmpty(header.getPhoneNumber())) {
            return Single.error(new RuntimeException("Phone number cannot be empty"));
        }

        String type = communicationChannel.getType().name();
        String addr = communicationChannel.getType() == CommunicationChannel.Type.EMAIL ? header.getEmail() : header.getPhoneNumber();
        String msg = message.getBody();

        log.info(String.format("An %s has been send to %s with the content as %s", type, addr, msg));

        return Single.just(true);
    }
}
