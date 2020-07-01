package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientInfo {

    @JsonProperty("UserName")
    private String userName;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Version")
    private String version;

    @JsonProperty("AccountNumber")
    private String accountNumber;

    @JsonProperty("AccountPin")
    private String accountPin;

    @JsonProperty("AccountEntity")
    private String accountEntity;

    @JsonProperty("AccountCountryCode")
    private String accountCountryCode;

    @JsonProperty("Source")
    private Integer source;
}
