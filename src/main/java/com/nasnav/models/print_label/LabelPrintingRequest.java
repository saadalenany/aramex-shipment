package com.nasnav.models.print_label;

import com.nasnav.models.LabelInfo;
import com.nasnav.models.Request;
import com.nasnav.models.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LabelPrintingRequest extends Request {

    @JsonProperty("LabelInfo")
    private LabelInfo labelInfo;

    @JsonProperty("OriginEntity")
    private String originEntity;

    @JsonProperty("ProductGroup")
    private String productGroup;

    @JsonProperty("ShipmentNumber")
    private String shipmentNumber;

    @JsonProperty("Transaction")
    private Transaction transaction;

}
