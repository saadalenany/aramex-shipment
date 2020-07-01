package com.nasnav.models.create_shipment;

import com.nasnav.models.ProcessedShipment;
import com.nasnav.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShipmentCreationResponse extends Response {

    @JsonProperty("Shipments")
    private List<ProcessedShipment> processedShipment;
}
