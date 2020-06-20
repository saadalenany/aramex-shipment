package aramex.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {

    @JsonProperty("Line1")
    private String line1;

    @JsonProperty("Line2")
    private String line2;

    @JsonProperty("Line3")
    private String line3;

    @JsonProperty("City")
    private String city;

    @JsonProperty("StateOrProvinceCode")
    private String stateOrProvinceCode;

    @JsonProperty("PostCode")
    private String postCode;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Longitude")
    private int longitude;

    @JsonProperty("Latitude")
    private int latitude;

    @JsonProperty("BuildingNumber")
    private String buildingNumber;

    @JsonProperty("BuildingName")
    private String buildingName;

    @JsonProperty("Floor")
    private String floor;

    @JsonProperty("Apartment")
    private String apartment;

    @JsonProperty("POBox")
    private String pOBox;

    @JsonProperty("Description")
    private String description;
}
