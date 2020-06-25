package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LabelInfo {

    @JsonProperty("ReportID")
    private Integer reportId;

    @JsonProperty("ReportType")
    private String reportType;
}
