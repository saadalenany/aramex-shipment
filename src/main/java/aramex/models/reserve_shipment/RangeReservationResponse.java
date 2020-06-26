package aramex.models.reserve_shipment;

import aramex.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RangeReservationResponse extends Response {

    @JsonProperty("FromWaybill")
    private String fromWayBill;

    @JsonProperty("ToWaybill")
    private String toWayBill;
}
