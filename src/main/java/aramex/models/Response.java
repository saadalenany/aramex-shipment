package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Response {

    @JsonProperty("Transaction")
    private Transaction transaction;

    @JsonProperty("Notifications")
    private List<Notification> notifications;

    @JsonProperty("HasErrors")
    private Boolean hasErrors;
}
