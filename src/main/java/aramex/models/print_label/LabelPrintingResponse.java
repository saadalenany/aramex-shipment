package aramex.models.print_label;

import aramex.models.Response;
import aramex.models.ShipmentLabel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LabelPrintingResponse extends Response {

    @JsonProperty("ShipmentNumber")
    private String shipmentNumber;

    @JsonProperty("ShipmentLabel")
    private ShipmentLabel shipmentLabel;
}
