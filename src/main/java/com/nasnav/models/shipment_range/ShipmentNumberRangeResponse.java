package com.nasnav.models.shipment_range;

import com.nasnav.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShipmentNumberRangeResponse extends Response {

    @JsonProperty("FromWaybill")
    private String fromWayBill;

    @JsonProperty("ToWaybill")
    private String toWayBill;
}
