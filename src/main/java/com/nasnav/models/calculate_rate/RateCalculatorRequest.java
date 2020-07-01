package com.nasnav.models.calculate_rate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nasnav.models.Address;
import com.nasnav.models.Request;
import com.nasnav.models.ShipmentDetails;
import lombok.Data;

@Data
public class RateCalculatorRequest extends Request {

    @JsonProperty("OriginAddress")
    private Address originAddress;

    @JsonProperty("DestinationAddress")
    private Address destinationAddress;

    @JsonProperty("ShipmentDetails")
    private ShipmentDetails shipmentDetails;

    @JsonProperty("PreferredCurrencyCode")
    private String preferredCurrencyCode;
}
