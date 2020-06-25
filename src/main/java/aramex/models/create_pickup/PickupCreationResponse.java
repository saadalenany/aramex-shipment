package aramex.models.create_pickup;

import aramex.models.ProcessedPickup;
import aramex.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PickupCreationResponse extends Response {

    @JsonProperty("ProcessedPickup")
    private ProcessedPickup processedPickup;
}
