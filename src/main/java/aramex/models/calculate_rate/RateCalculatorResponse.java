package aramex.models.calculate_rate;

import aramex.models.Money;
import aramex.models.RateDetails;
import aramex.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class RateCalculatorResponse extends Response {

    @JsonProperty("TotalAmount")
    private Money totalAmount;

    @JsonProperty("RateDetails")
    private RateDetails rateDetails;
}
