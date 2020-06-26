package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class ProcessedPickup {

    @EqualsAndHashCode.Exclude
    @JsonProperty("ID")
    private String id;

    @EqualsAndHashCode.Exclude
    @JsonProperty("GUID")
    private String guid;

    @JsonProperty("Reference1")
    private String reference1;

    @JsonProperty("Reference2")
    private String reference2;

    @JsonProperty("ProcessedShipments")
    private List<ProcessedShipment> processedShipments;
}
