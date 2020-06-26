package aramex.models.pickup;

import aramex.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PickupCancellationResponse extends Response {

    @JsonProperty("Message")
    private String message;
}
