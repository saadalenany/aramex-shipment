package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Pickup {

    @JsonProperty("PickupAddress")
    private Address pickupAddress;

    @JsonProperty("PickupContact")
    private Contact pickupContact;

    @JsonProperty("PickupLocation")
    private String pickupLocation;

    @JsonProperty("PickupDate")
    private String pickupDate;

    @JsonProperty("ReadyTime")
    private String readyTime;

    @JsonProperty("LastPickupTime")
    private String lastPickupTime;

    @JsonProperty("ClosingTime")
    private String closingTime;

    @JsonProperty("Comments")
    private String comments;

    @JsonProperty("Reference1")
    private String reference1;

    @JsonProperty("Reference2")
    private String reference2;

    @JsonProperty("Vehicle")
    private String vehicle;

    @JsonProperty("Shipments")
    private List<Shipment> shipments;

    @JsonProperty("PickupItems")
    private List<PickupItemDetail> pickupItems;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("ExistingShipments")
    private String existingShipments;

    @JsonProperty("Branch")
    private String branch;

    @JsonProperty("RouteCode")
    private String routeCode;
}
