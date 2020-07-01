package com.nasnav.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShipmentDetails {

    @JsonProperty("Dimensions")
    private Dimensions dimensions;

    @JsonProperty("ActualWeight")
    private Weight actualWeight;

    @JsonProperty("ChargeableWeight")
    private Weight chargeableWeight;

    @JsonProperty("DescriptionOfGoods")
    private String descriptionOfGoods;

    @JsonProperty("GoodsOriginCountry")
    private String goodsOriginCountry;

    @JsonProperty("NumberOfPieces")
    private Integer numberOfPieces;

    @JsonProperty("ProductGroup")
    private String productGroup;

    @JsonProperty("ProductType")
    private String productType;

    @JsonProperty("PaymentType")
    private String paymentType;

    @JsonProperty("PaymentOptions")
    private String paymentOptions;

    @JsonProperty("DeliveryInstructions")
    private String deliveryInstructions;

    @JsonProperty("CustomsValueAmount")
    private Money customsValueAmount;

    @JsonProperty("CashOnDeliveryAmount")
    private Money cashOnDeliveryAmount;

    @JsonProperty("InsuranceAmount")
    private Money insuranceAmount;

    @JsonProperty("CashAdditionalAmount")
    private Money cashAdditionalAmount;

    @JsonProperty("CashAdditionalAmountDescription")
    private String cashAdditionalAmountDescription;

    @JsonProperty("CollectAmount")
    private Money collectAmount;

    @JsonProperty("Services")
    private String services;

    @JsonProperty("Items")
    private List<ShipmentItem> items;
}
