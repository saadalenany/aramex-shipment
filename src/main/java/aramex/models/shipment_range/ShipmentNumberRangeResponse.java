package aramex.models.shipment_range;

import aramex.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShipmentNumberRangeResponse extends Response {

    @JsonProperty("FromWaybill")
    private String fromWayBill;

    @JsonProperty("ToWaybill")
    private String toWayBill;
}
