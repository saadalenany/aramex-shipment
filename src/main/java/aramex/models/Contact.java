package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Contact {

    @JsonProperty("Department")
    private String department;

    @JsonProperty("PersonName")
    private String personName;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("CompanyName")
    private String companyName;

    @JsonProperty("PhoneNumber1")
    private String phoneNumber1;

    @JsonProperty("PhoneNumber1Ext")
    private String phoneNumber1Ext;

    @JsonProperty("PhoneNumber2")
    private String phoneNumber2;

    @JsonProperty("PhoneNumber2Ext")
    private String phoneNumber2Ext;

    @JsonProperty("FaxNumber")
    private String faxNumber;

    @JsonProperty("CellPhone")
    private String cellPhone;

    @JsonProperty("EmailAddress")
    private String emailAddress;

    @JsonProperty("Type")
    private String type;

}
