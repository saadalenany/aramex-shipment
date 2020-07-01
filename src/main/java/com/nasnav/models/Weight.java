package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weight {

    @JsonProperty("Unit")
    private String unit;

    @JsonProperty("Value")
    private Double value;
}
