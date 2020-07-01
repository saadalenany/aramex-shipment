package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Volume {

    @JsonAlias("Value")
    private Double value;

    @JsonAlias("Unit")
    private String unit;
}
