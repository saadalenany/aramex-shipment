package com.nasnav.controller;

import com.nasnav.BaseTest;
import com.nasnav.models.create_shipment.ShipmentCreationRequest;
import com.nasnav.models.create_shipment.ShipmentCreationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CreateShipmentTest extends BaseTest {

    private static final String REQUEST_JSON = "{\"ClientInfo\":{\"UserName\":\"testingapi@aramex.com\",\"Password\":\"R123456789$r\",\"Version\":\"v1\",\"AccountNumber\":\"20016\",\"AccountPin\":\"331421\",\"AccountEntity\":\"AMM\",\"AccountCountryCode\":\"JO\",\"Source\":24},\"LabelInfo\":null,\"Shipments\":[{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Shipper\":{\"Reference1\":\"\",\"Reference2\":\"\",\"AccountNumber\":\"20016\",\"PartyAddress\":{\"Line1\":\"Test\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"Amman\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"JO\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"Contact\":{\"Department\":\"\",\"PersonName\":\"aramex\",\"Title\":\"\",\"CompanyName\":\"aramex\",\"PhoneNumber1\":\"009625515111\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"9677956000200\",\"EmailAddress\":\"test@test.com\",\"Type\":\"\"}},\"Consignee\":{\"Reference1\":\"\",\"Reference2\":\"\",\"AccountNumber\":\"\",\"PartyAddress\":{\"Line1\":\"Test\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"Dubai\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"AE\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":\"\",\"BuildingName\":\"\",\"Floor\":\"\",\"Apartment\":\"\",\"POBox\":null,\"Description\":\"\"},\"Contact\":{\"Department\":\"\",\"PersonName\":\"aramex\",\"Title\":\"\",\"CompanyName\":\"aramex\",\"PhoneNumber1\":\"009625515111\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"9627956000200\",\"EmailAddress\":\"test@test.com\",\"Type\":\"\"}},\"ThirdParty\":{\"Reference1\":\"\",\"Reference2\":\"\",\"AccountNumber\":\"\",\"PartyAddress\":{\"Line1\":\"\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"Contact\":{\"Department\":\"\",\"PersonName\":\"\",\"Title\":\"\",\"CompanyName\":\"\",\"PhoneNumber1\":\"\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"\",\"EmailAddress\":\"\",\"Type\":\"\"}},\"ShippingDateTime\":\"/Date(1484085970000-0500)/\",\"DueDate\":\"/Date(1484085970000-0500)/\",\"Comments\":\"\",\"PickupLocation\":\"\",\"OperationsInstructions\":\"\",\"Details\":{\"Dimensions\":null,\"ActualWeight\":{\"Unit\":\"KG\",\"Value\":0.5},\"ChargeableWeight\":null,\"DescriptionOfGoods\":\"Books\",\"GoodsOriginCountry\":\"JO\",\"NumberOfPieces\":1,\"ProductGroup\":\"EXP\",\"ProductType\":\"PDX\",\"PaymentType\":\"P\",\"PaymentOptions\":\"\",\"CustomsValueAmount\":null,\"CashOnDeliveryAmount\":null,\"InsuranceAmount\":null,\"CashAdditionalAmount\":null,\"CashAdditionalAmountDescription\":\"\",\"CollectAmount\":null,\"Services\":\"\",\"Items\":[]},\"Attachments\":[],\"ForeignHAWB\":\"\",\"TransportType\":0,\"PickupGUID\":\"\",\"Number\":null}],\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"}}";

    private static final String RESPONSE_JSON = "{\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"},\"Notifications\":[],\"HasErrors\":false,\"Shipments\":[{\"ID\":\"32615496023\",\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"ForeignHAWB\":\"\",\"HasErrors\":false,\"Notifications\":[],\"ShipmentLabel\":null,\"ShipmentDetails\":{\"Dimensions\":null,\"ActualWeight\":null,\"ChargeableWeight\":{\"Unit\":\"KG\",\"Value\":0.5},\"DescriptionOfGoods\":\"Books\",\"GoodsOriginCountry\":\"JO\",\"NumberOfPieces\":1,\"ProductGroup\":\"EXP\",\"ProductType\":\"PDX\",\"PaymentType\":\"P\",\"PaymentOptions\":\"\",\"DeliveryInstructions\":null,\"CustomsValueAmount\":null,\"CashOnDeliveryAmount\":null,\"InsuranceAmount\":null,\"CashAdditionalAmount\":null,\"CashAdditionalAmountDescription\":null,\"CollectAmount\":null,\"Services\":\"\",\"Items\":null},\"ShipmentAttachments\":[]}]}";

    private static final String URL = "/shipping/create_shipment";

    @Test
    public void testCreateShipment_success() throws Exception {
        final ShipmentCreationRequest request = createShipmentCreationRequest();
        final ShipmentCreationResponse successfulResponse = createSuccessfulResponse();

        final ShipmentCreationResponse shipmentCreationResponse = postForObject(URL, request, ShipmentCreationResponse.class);

        assertNotNull(shipmentCreationResponse);
        assertEquals(successfulResponse, shipmentCreationResponse);
    }

    @Test
    public void testCreateShipment_invalidUsernameOrPassword() throws Exception {
        //---------------------TEST USERNAME-------------------
        final ShipmentCreationRequest request = createShipmentCreationRequest();
        String correctUserName = request.getClientInfo().getUserName();
        request.getClientInfo().setUserName("None");

        ShipmentCreationResponse shipmentCreationResponse = postForObject(URL, request, ShipmentCreationResponse.class);

        assertNotNull(shipmentCreationResponse);
        Assertions.assertTrue(shipmentCreationResponse.getHasErrors());
        Assertions.assertFalse(shipmentCreationResponse.getNotifications().isEmpty());
        assertEquals("ERR01", shipmentCreationResponse.getNotifications().get(0).getCode());
        assertEquals("ClientInfo - Invalid username or password", shipmentCreationResponse.getNotifications().get(0).getMessage());

        //---------------------TEST PASSWORD-------------------
        request.getClientInfo().setUserName(correctUserName);
        request.getClientInfo().setPassword("None");

        shipmentCreationResponse = postForObject(URL, request, ShipmentCreationResponse.class);

        assertNotNull(shipmentCreationResponse);
        Assertions.assertTrue(shipmentCreationResponse.getHasErrors());
        Assertions.assertFalse(shipmentCreationResponse.getNotifications().isEmpty());
        assertEquals("ERR01", shipmentCreationResponse.getNotifications().get(0).getCode());
        assertEquals("ClientInfo - Invalid username or password", shipmentCreationResponse.getNotifications().get(0).getMessage());
    }


    private ShipmentCreationRequest createShipmentCreationRequest() throws JsonProcessingException {
        return objectMapper.readValue(REQUEST_JSON, ShipmentCreationRequest.class);
    }

    private ShipmentCreationResponse createSuccessfulResponse() throws JsonProcessingException {
        return objectMapper.readValue(RESPONSE_JSON, ShipmentCreationResponse.class);
    }

}
