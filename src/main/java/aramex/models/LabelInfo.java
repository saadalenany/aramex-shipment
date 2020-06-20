package aramex.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class LabelInfo {

    @JsonAlias({"ReportId", "report_id"})
    private Integer reportId;

    @JsonAlias({"ReportType", "report_type"})
    private String reportType;
}
