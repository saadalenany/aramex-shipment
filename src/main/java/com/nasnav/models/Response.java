package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class Response {

    @JsonProperty("Transaction")
    private Transaction transaction;

    @JsonProperty("Notifications")
    private List<Notification> notifications;

    @JsonProperty("HasErrors")
    private Boolean hasErrors;
}
