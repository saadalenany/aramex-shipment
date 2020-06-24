package aramex.models.calculate_rate;

import aramex.models.*;
import com.fasterxml.jackson.annotation.JsonProperty;
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
