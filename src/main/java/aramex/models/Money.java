package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Money {

    @JsonProperty("CurrencyCode")
    private String currencyCode;

    @JsonProperty("Value")
    private Double value;
}
