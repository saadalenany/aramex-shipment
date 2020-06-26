package aramex.models.pickup;

import aramex.models.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PickupCancellationRequest extends Request {

    @JsonProperty("PickupGUID")
    private String pickupGuid;

    @JsonProperty("Comments")
    private String comments;
}
