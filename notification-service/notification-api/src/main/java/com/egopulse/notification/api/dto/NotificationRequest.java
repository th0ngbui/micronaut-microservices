package com.egopulse.notification.api.dto;

import com.egopulse.notification.api.model.CommunicationChannel;
import com.egopulse.notification.api.model.Header;
import com.egopulse.notification.api.model.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    private Header header;
    private Message message;
    private CommunicationChannel communicationChannel;
}
