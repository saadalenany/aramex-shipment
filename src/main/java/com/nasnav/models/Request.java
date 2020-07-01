package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Request {

    @JsonProperty("ClientInfo")
    private ClientInfo clientInfo;

    @JsonProperty("Transaction")
    private Transaction transaction;

}
