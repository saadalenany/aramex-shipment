package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShipmentItem {

    @JsonProperty("PackageType")
    private String packageType;

    @JsonProperty("Quantity")
    private Integer quantity;

    @JsonProperty("Weight")
    private Weight weight;

    @JsonProperty("Comments")
    private String comments;
}
