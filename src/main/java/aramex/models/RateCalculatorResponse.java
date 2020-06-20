package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RateCalculatorResponse {

    @JsonProperty("Transaction")
    private Transaction transaction;

    @JsonProperty("Notifications")
    private List<Notification> notifications;

    @JsonProperty("HasErrors")
    private Boolean hasErrors;

    @JsonProperty("TotalAmount")
    private Money totalAmount;

    @JsonProperty("RateDetails")
    private RateDetails rateDetails;
}
