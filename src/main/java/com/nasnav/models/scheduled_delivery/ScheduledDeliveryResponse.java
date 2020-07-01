package com.nasnav.models.scheduled_delivery;

import com.nasnav.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScheduledDeliveryResponse extends Response {

    @JsonProperty("Id")
    private Integer id;
}
