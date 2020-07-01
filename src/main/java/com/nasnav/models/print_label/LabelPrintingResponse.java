package com.nasnav.models.print_label;

import com.nasnav.models.Response;
import com.nasnav.models.ShipmentLabel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LabelPrintingResponse extends Response {

    @JsonProperty("ShipmentNumber")
    private String shipmentNumber;

    @JsonProperty("ShipmentLabel")
    private ShipmentLabel shipmentLabel;
}
