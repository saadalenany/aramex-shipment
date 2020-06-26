package aramex.models.scheduled_delivery;

import aramex.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScheduledDeliveryResponse extends Response {

    @JsonProperty("Id")
    private Integer id;
}
