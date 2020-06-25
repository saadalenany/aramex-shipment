package aramex.models.print_label;

import aramex.models.LabelInfo;
import aramex.models.Request;
import aramex.models.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LabelPrintingRequest extends Request {

    @JsonProperty("LabelInfo")
    private LabelInfo labelInfo;

    @JsonProperty("OriginEntity")
    private String originEntity;

    @JsonProperty("ProductGroup")
    private String productGroup;

    @JsonProperty("ShipmentNumber")
    private String shipmentNumber;

    @JsonProperty("Transaction")
    private Transaction transaction;

}
