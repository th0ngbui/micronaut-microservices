package com.egopulse.practice.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medication {

    private String id;
    private String pznDrugInformation;
    private String freeTextInformation;
    private String recipeInformation;
}
