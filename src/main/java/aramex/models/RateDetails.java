package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RateDetails {

    @JsonProperty("Amount")
    private Double amount;

    @JsonProperty("OtherAmount1")
    private Double otherAmount1;

    @JsonProperty("OtherAmount2")
    private Double otherAmount2;

    @JsonProperty("OtherAmount3")
    private Double otherAmount3;

    @JsonProperty("OtherAmount4")
    private Double otherAmount4;

    @JsonProperty("OtherAmount5")
    private Double otherAmount5;

    @JsonProperty("TotalAmountBeforeTax")
    private Double totalAmountBeforeTax;

    @JsonProperty("TaxAmount")
    private Double taxAmount;
}
