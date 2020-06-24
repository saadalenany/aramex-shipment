package aramex.models.calculate_rate;

import aramex.models.Money;
import aramex.models.RateDetails;
import aramex.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class RateCalculatorResponse extends Response {

    @JsonProperty("TotalAmount")
    private Money totalAmount;

    @JsonProperty("RateDetails")
    private RateDetails rateDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RateCalculatorResponse)) return false;
        if (!super.equals(o)) return false;
        RateCalculatorResponse that = (RateCalculatorResponse) o;
        return totalAmount.equals(that.totalAmount) &&
                rateDetails.equals(that.rateDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalAmount, rateDetails);
    }
}
