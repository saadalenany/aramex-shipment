package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class ProcessedShipment {

    @EqualsAndHashCode.Exclude
    @JsonProperty("ID")
    private String id;

    @JsonProperty("Reference1")
    private String reference1;

    @JsonProperty("Reference2")
    private String reference2;

    @JsonProperty("Reference3")
    private String reference3;

    @JsonProperty("ForeignHAWB")
    private String foreignHAWB;

    @JsonProperty("HasErrors")
    private boolean hasErrors;

    @JsonProperty("Notifications")
    private List<Notification> notifications;

    @JsonProperty("ShipmentLabel")
    private ShipmentLabel shipmentLabel;

    @JsonProperty("ShipmentDetails")
    private ShipmentDetails shipmentDetails;

    @JsonProperty("ShipmentAttachments")
    private List<Attachment> shipmentAttachments;
}
