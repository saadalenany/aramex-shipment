package com.nasnav.models.create_shipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nasnav.models.LabelInfo;
import com.nasnav.models.Request;
import com.nasnav.models.Shipment;
import lombok.Data;

import java.util.List;

@Data
public class ShipmentCreationRequest extends Request {

    @JsonProperty("LabelInfo")
    private LabelInfo labelInfo;

    @JsonProperty("Shipments")
    private List<Shipment> shipments;
}
