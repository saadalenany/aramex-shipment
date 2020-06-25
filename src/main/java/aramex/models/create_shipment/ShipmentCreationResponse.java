package aramex.models.create_shipment;

import aramex.models.ProcessedShipment;
import aramex.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShipmentCreationResponse extends Response {

    @JsonProperty("Shipments")
    private List<ProcessedShipment> processedShipment;
}
