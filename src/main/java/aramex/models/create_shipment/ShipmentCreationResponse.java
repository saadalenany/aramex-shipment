package aramex.models.create_shipment;

import aramex.models.ProcessedShipment;
import aramex.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class ShipmentCreationResponse extends Response {

    @JsonProperty("Shipments")
    private List<ProcessedShipment> processedShipment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipmentCreationResponse)) return false;
        if (!super.equals(o)) return false;
        ShipmentCreationResponse that = (ShipmentCreationResponse) o;
        return processedShipment.equals(that.processedShipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), processedShipment);
    }
}
