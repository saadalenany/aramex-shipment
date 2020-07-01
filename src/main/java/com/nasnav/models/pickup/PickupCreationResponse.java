package com.nasnav.models.pickup;

import com.nasnav.models.ProcessedPickup;
import com.nasnav.models.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PickupCreationResponse extends Response {

    @JsonProperty("ProcessedPickup")
    private ProcessedPickup processedPickup;
}
