package com.nasnav.models.shipment_range;

import com.nasnav.models.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShipmentNumberRangeRequest extends Request {

    @JsonProperty("Entity")
    private String entity;

    @JsonProperty("ProductGroup")
    private String productGroup;

    @JsonProperty("Count")
    private Integer count;
}
