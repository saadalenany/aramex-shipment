package aramex.models.pickup;

import aramex.models.LabelInfo;
import aramex.models.Pickup;
import aramex.models.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PickupCreationRequest extends Request {

    @JsonProperty("LabelInfo")
    private LabelInfo labelInfo;

    @JsonProperty("Pickup")
    private Pickup pickup;
}
