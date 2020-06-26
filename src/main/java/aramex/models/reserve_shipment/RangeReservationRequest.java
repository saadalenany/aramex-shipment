package aramex.models.reserve_shipment;

import aramex.models.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RangeReservationRequest extends Request {

    @JsonProperty("Entity")
    private String entity;

    @JsonProperty("ProductGroup")
    private String productGroup;

    @JsonProperty("Count")
    private Integer count;
}
