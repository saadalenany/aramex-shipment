package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.Date;

@Data
public class DateTime {

    @JsonAlias({"ShippingDate", "shipping_date"})
    private Date shippingDate;

    @JsonAlias({"DueDate", "due_date"})
    private Date dueDate;
}
