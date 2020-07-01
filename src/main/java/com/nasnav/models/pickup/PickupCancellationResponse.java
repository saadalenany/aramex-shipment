package com.nasnav.models.pickup;

import com.nasnav.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PickupCancellationResponse extends Response {

    @JsonProperty("Message")
    private String message;
}
