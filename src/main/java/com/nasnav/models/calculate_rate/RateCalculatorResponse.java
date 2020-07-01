package com.nasnav.models.calculate_rate;

import com.nasnav.models.Money;
import com.nasnav.models.RateDetails;
import com.nasnav.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RateCalculatorResponse extends Response {

    @JsonProperty("TotalAmount")
    private Money totalAmount;

    @JsonProperty("RateDetails")
    private RateDetails rateDetails;
}
