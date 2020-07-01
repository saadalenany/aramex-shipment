package com.nasnav.models.pickup;

import com.nasnav.models.LabelInfo;
import com.nasnav.models.Pickup;
import com.nasnav.models.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PickupCreationRequest extends Request {

    @JsonProperty("LabelInfo")
    private LabelInfo labelInfo;

    @JsonProperty("Pickup")
    private Pickup pickup;
}
