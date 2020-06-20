package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dimensions {

    @JsonProperty("Length")
    private Double length;

    @JsonProperty("Width")
    private Double width;

    @JsonProperty("Height")
    private Double height;

    @JsonProperty("Unit")
    private String unit;
}
