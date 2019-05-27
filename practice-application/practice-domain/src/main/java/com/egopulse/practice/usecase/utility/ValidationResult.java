package com.egopulse.practice.usecase.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class ValidationResult {

    List<Violation> violations;
}
