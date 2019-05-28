package com.egopulse.notification.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationChannel {

    public enum Type {
        EMAIL,
        SMS
    }

    private Type type;
}
