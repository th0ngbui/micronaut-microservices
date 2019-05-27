package com.egopulse.practice.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationPlan {

    private String id;
    private String version;
    private String language;
    private long printedDate;
    private List<Medication> medications;
}
