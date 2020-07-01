package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScheduledDelivery {

    @JsonProperty("PreferredDeliveryDate")
    private String preferredDeliveryDate;

    @JsonProperty("PreferredDeliveryTimeFrame")
    private String preferredDeliveryTimeFrame;

    @JsonProperty("PreferredDeliveryTime")
    private String preferredDeliveryTime;
}
