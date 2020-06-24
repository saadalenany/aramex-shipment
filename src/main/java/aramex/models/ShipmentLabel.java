package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShipmentLabel {

    @JsonProperty("LabelURL")
    private String labelURL;

    @JsonProperty("LabelFileContents")
    private byte[] labelFileContents;
}
