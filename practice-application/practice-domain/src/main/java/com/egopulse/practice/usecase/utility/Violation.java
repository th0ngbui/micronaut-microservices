package com.egopulse.practice.usecase.utility;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Violation {
    private String code;
    private String message;
}
