package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RateCalculatorRequest {

    @JsonProperty("ClientInfo")
    private ClientInfo clientInfo;

    @JsonProperty("Transaction")
    private Transaction transaction;

    @JsonProperty("OriginAddress")
    private Address originAddress;

    @JsonProperty("DestinationAddress")
    private Address destinationAddress;

    @JsonProperty("ShipmentDetails")
    private ShipmentDetails shipmentDetails;

    @JsonProperty("PreferredCurrencyCode")
    private String preferredCurrencyCode;
}
