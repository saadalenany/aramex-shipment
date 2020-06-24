package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Shipment {

    @JsonProperty("Reference1")
    private String reference1;

    @JsonProperty("Reference2")
    private String reference2;

    @JsonProperty("Reference3")
    private String reference3;

    @JsonProperty("ForeignHAWB")
    private String foreignHAWB;

    @JsonProperty("TransportType")
    private Integer transportType;

    @JsonProperty("Shipper")
    private Party shipper;

    @JsonProperty("Consignee")
    private Party consignee;

    @JsonProperty("ThirdParty")
    private Party thirdParty;

    @JsonProperty("ShippingDateTime")
    private String shippingDateTime;

    @JsonProperty("DueDate")
    private String dueDate;

    @JsonProperty("Comments")
    private String comments;

    @JsonProperty("PickupLocation")
    private String pickupLocation;

    @JsonProperty("OperationsInstructions")
    private String operationsInstructions;

    @JsonProperty("AccountsInstructions")
    private String accountsInstructions;

    @JsonProperty("Details")
    private ShipmentDetails details;

    @JsonProperty("Attachments")
    private List<Attachment> attachments;

    @JsonProperty("PickupGUID")
    private String pickupGUID;

    @JsonProperty("Number")
    private String number;
}
