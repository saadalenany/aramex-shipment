package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ShipmentLabel {

    @JsonProperty("LabelURL")
    @EqualsAndHashCode.Exclude
    private String labelURL;

    @JsonProperty("LabelFileContents")
    private byte[] labelFileContents;
}
