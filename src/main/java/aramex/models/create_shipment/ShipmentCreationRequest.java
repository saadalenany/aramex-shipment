package aramex.models.create_shipment;

import aramex.models.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShipmentCreationRequest extends Request {

    @JsonProperty("LabelInfo")
    private LabelInfo labelInfo;

    @JsonProperty("Shipments")
    private List<Shipment> shipments;
}
