package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Notification {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Message")
    private String message;
}
