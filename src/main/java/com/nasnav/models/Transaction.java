package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Transaction {

    @JsonProperty("Reference1")
    private String reference1;

    @JsonProperty("Reference2")
    private String reference2;

    @JsonProperty("Reference3")
    private String reference3;

    @JsonProperty("Reference4")
    private String reference4;

    @JsonProperty("Reference5")
    private String reference5;
}
