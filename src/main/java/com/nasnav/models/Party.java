package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Party {

    @JsonProperty("Reference1")
    private String reference1;

    @JsonProperty("Reference2")
    private String reference2;

    @JsonProperty("AccountNumber")
    private String accountNumber;

    @JsonProperty("PartyAddress")
    private Address partyAddress;

    @JsonProperty("Contact")
    private Contact contact;

}
