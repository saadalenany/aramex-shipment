package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateCalculatorResponse that = (RateCalculatorResponse) o;
        return transaction.equals(that.transaction) &&
                notifications.equals(that.notifications) &&
                hasErrors.equals(that.hasErrors) &&
                totalAmount.equals(that.totalAmount) &&
                rateDetails.equals(that.rateDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction, notifications, hasErrors, totalAmount, rateDetails);
    }
}
