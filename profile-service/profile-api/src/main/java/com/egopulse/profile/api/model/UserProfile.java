package com.egopulse.profile.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    private String id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String insuranceNumber;
}
