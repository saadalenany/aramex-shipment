package aramex.models.scheduled_delivery;

import aramex.models.Address;
import aramex.models.Request;
import aramex.models.ScheduledDelivery;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScheduledDeliveryRequest extends Request {

    @JsonProperty("Address")
    private Address address;

    @JsonProperty("ScheduledDelivery")
    private ScheduledDelivery scheduledDelivery;

    @JsonProperty("ConsigneePhone")
    private String consigneePhone;

    @JsonProperty("Entity")
    private String entity;

    @JsonProperty("ProductGroup")
    private String productGroup;

    @JsonProperty("Reference1")
    private String reference1;

    @JsonProperty("Reference2")
    private String reference2;

    @JsonProperty("Reference3")
    private String reference3;

    @JsonProperty("ShipmentNumber")
    private String shipmentNumber;

    @JsonProperty("ShipperNumber")
    private String shipperNumber;

    @JsonProperty("ShipperReference")
    private String shipperReference;
}
