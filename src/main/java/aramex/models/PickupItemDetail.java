package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PickupItemDetail {

    @JsonProperty("ProductGroup")
    private String productGroup;

    @JsonProperty("ProductType")
    private String productType;

    @JsonProperty("NumberOfShipments")
    private Integer numberOfShipments;

    @JsonProperty("PackageType")
    private String packageType;

    @JsonProperty("Payment")
    private String payment;

    @JsonProperty("ShipmentWeight")
    private Weight shipmentWeight;

    @JsonProperty("ShipmentVolume")
    private Volume shipmentVolume;

    @JsonProperty("NumberOfPieces")
    private Integer numberOfPieces;

    @JsonProperty("CashAmount")
    private Money cashAmount;

    @JsonProperty("ExtraCharges")
    private Money extraCharges;

    @JsonProperty("ShipmentDimensions")
    private Dimensions shipmentDimensions;

    @JsonProperty("Comments")
    private String comments;
}
