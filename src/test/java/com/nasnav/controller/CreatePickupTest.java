package com.nasnav.controller;

import com.nasnav.BaseTest;
import com.nasnav.models.pickup.PickupCreationRequest;
import com.nasnav.models.pickup.PickupCreationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CreatePickupTest extends BaseTest {

    private static final String REQUEST_JSON = "{\"ClientInfo\":{\"UserName\":\"testingapi@aramex.com\",\"Password\":\"R123456789$r\",\"Version\":\"v1\",\"AccountNumber\":\"20016\",\"AccountPin\":\"331421\",\"AccountEntity\":\"AMM\",\"AccountCountryCode\":\"JO\",\"Source\":24},\"LabelInfo\":{\"ReportID\":9201,\"ReportType\":\"URL\"},\"Pickup\":{\"PickupAddress\":{\"Line1\":\"Test\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"Amman\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"JO\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"PickupContact\":{\"Department\":\"\",\"PersonName\":\"test\",\"Title\":\"\",\"CompanyName\":\"test\",\"PhoneNumber1\":\"1111111111111\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"11111111111111\",\"EmailAddress\":\"test@test.com\",\"Type\":\"\"},\"PickupLocation\":\"test\",\"PickupDate\":\"/Date(1593119257529-0500)/\",\"ReadyTime\":\"/Date(1693118259529-0500)/\",\"LastPickupTime\":\"/Date(1693118269529-0500)/\",\"ClosingTime\":\"/Date(1793118257529-0500)/\",\"Comments\":\"\",\"Reference1\":\"001\",\"Reference2\":\"\",\"Vehicle\":\"\",\"Shipments\":[{\"Reference1\":\"123\",\"Reference2\":\"\",\"Reference3\":\"\",\"Shipper\":{\"Reference1\":\"\",\"Reference2\":\"\",\"AccountNumber\":\"20016\",\"PartyAddress\":{\"Line1\":\"Test\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"Amman\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"JO\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"Contact\":{\"Department\":\"\",\"PersonName\":\"Test\",\"Title\":\"\",\"CompanyName\":\"Test\",\"PhoneNumber1\":\"5555\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"5555\",\"EmailAddress\":\"m@m.com\",\"Type\":\"\"}},\"Consignee\":{\"Reference1\":\"\",\"Reference2\":\"\",\"AccountNumber\":\"\",\"PartyAddress\":{\"Line1\":\"Test\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"Dubai\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"AE\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":\"\",\"BuildingName\":\"\",\"Floor\":\"\",\"Apartment\":\"\",\"POBox\":null,\"Description\":\"\"},\"Contact\":{\"Department\":\"\",\"PersonName\":\"Test\",\"Title\":\"\",\"CompanyName\":\"Test\",\"PhoneNumber1\":\"555\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"555\",\"EmailAddress\":\"f@f.com\",\"Type\":\"\"}},\"ThirdParty\":{\"Reference1\":\"\",\"Reference2\":\"\",\"AccountNumber\":\"\",\"PartyAddress\":{\"Line1\":\"\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"Contact\":{\"Department\":\"\",\"PersonName\":\"\",\"Title\":\"\",\"CompanyName\":\"\",\"PhoneNumber1\":\"\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"\",\"EmailAddress\":\"\",\"Type\":\"\"}},\"ShippingDateTime\":\"/Date(1593138492805-0500)/\",\"DueDate\":\"/Date(1593138492805-0500)/\",\"Comments\":\"Comments ...\",\"PickupLocation\":\"Reception\",\"OperationsInstructions\":\"Fragile\",\"AccountingInstrcutions\":\"Get us a discount please\",\"Details\":{\"Dimensions\":null,\"ActualWeight\":{\"Unit\":\"KG\",\"Value\":0.5},\"ChargeableWeight\":null,\"DescriptionOfGoods\":\"Docs\",\"GoodsOriginCountry\":\"JO\",\"NumberOfPieces\":1,\"ProductGroup\":\"EXP\",\"ProductType\":\"PDX\",\"PaymentType\":\"P\",\"PaymentOptions\":\"\",\"CustomsValueAmount\":null,\"CashOnDeliveryAmount\":null,\"InsuranceAmount\":null,\"CashAdditionalAmount\":null,\"CashAdditionalAmountDescription\":\"\",\"CollectAmount\":null,\"Services\":\"\",\"Items\":[],\"DeliveryInstructions\":null},\"Attachments\":[],\"ForeignHAWB\":\"12212121212222\",\"TransportType\":0,\"PickupGUID\":null,\"Number\":\"\"}],\"PickupItems\":[{\"ProductGroup\":\"EXP\",\"ProductType\":\"PDX\",\"NumberOfShipments\":1,\"PackageType\":\"Box\",\"Payment\":\"P\",\"ShipmentWeight\":{\"Unit\":\"KG\",\"Value\":0.5},\"ShipmentVolume\":null,\"NumberOfPieces\":1,\"CashAmount\":null,\"ExtraCharges\":null,\"ShipmentDimensions\":{\"Length\":0,\"Width\":0,\"Height\":0,\"Unit\":\"\"},\"Comments\":\"Test\"}],\"Status\":\"Ready\",\"ExistingShipments\":null,\"Branch\":\"\",\"RouteCode\":\"\"},\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"}}";

    private static final String RESPONSE_JSON = "{\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"},\"Notifications\":[],\"HasErrors\":false,\"ProcessedPickup\":{\"ID\":\"F261B9C\",\"GUID\":\"23877685-c680-4bb0-961f-0b430b5b06ee\",\"Reference1\":\"001\",\"Reference2\":\"\",\"ProcessedShipments\":[{\"ID\":\"32615496642\",\"Reference1\":\"123\",\"Reference2\":\"\",\"Reference3\":\"\",\"ForeignHAWB\":\"12212121212222\",\"HasErrors\":false,\"Notifications\":[],\"ShipmentLabel\":{\"LabelURL\":\"http://www.sandbox.aramex.com/content/rpt_cache/ed230a846ff74b99a3dd473882c60c3f.pdf\",\"LabelFileContents\":\"\"},\"ShipmentDetails\":{\"Dimensions\":null,\"ActualWeight\":null,\"ChargeableWeight\":{\"Unit\":\"KG\",\"Value\":0.5},\"DescriptionOfGoods\":\"Docs\",\"GoodsOriginCountry\":\"JO\",\"NumberOfPieces\":1,\"ProductGroup\":\"EXP\",\"ProductType\":\"PDX\",\"PaymentType\":\"P\",\"PaymentOptions\":\"\",\"DeliveryInstructions\":null,\"CustomsValueAmount\":null,\"CashOnDeliveryAmount\":null,\"InsuranceAmount\":null,\"CashAdditionalAmount\":null,\"CashAdditionalAmountDescription\":null,\"CollectAmount\":null,\"Services\":\"\",\"Items\":null},\"ShipmentAttachments\":[]}]}}";

    private static final String URL = "/shipping/create_pickup";

    @Test
    public void testCreatePickup_success() throws Exception {
        final PickupCreationRequest request = createPickupCreationRequest();

        String foreignHAWB = String.valueOf(System.currentTimeMillis());
        request.getPickup().getShipments().get(0).setForeignHAWB(foreignHAWB);

        final PickupCreationResponse successfulResponse = createSuccessfulResponse();
        successfulResponse.getProcessedPickup().getProcessedShipments().get(0).setForeignHAWB(foreignHAWB);

        final PickupCreationResponse pickupCreationResponse = postForObject(URL, request, PickupCreationResponse.class);

        assertNotNull(pickupCreationResponse);
        assertEquals(successfulResponse, pickupCreationResponse);
    }

    @Test
    public void testCreatePickup_invalidUsernameOrPassword() throws Exception {
        //---------------------TEST USERNAME-------------------
        final PickupCreationRequest request = createPickupCreationRequest();
        String correctUserName = request.getClientInfo().getUserName();
        request.getClientInfo().setUserName("None");

        PickupCreationResponse pickupCreationResponse = postForObject(URL, request, PickupCreationResponse.class);

        assertNotNull(pickupCreationResponse);
        assertTrue(pickupCreationResponse.getHasErrors());
        assertFalse(pickupCreationResponse.getNotifications().isEmpty());
        assertEquals("ERR01", pickupCreationResponse.getNotifications().get(0).getCode());
        assertEquals("ClientInfo - Invalid username or password", pickupCreationResponse.getNotifications().get(0).getMessage());

        //---------------------TEST PASSWORD-------------------
        request.getClientInfo().setUserName(correctUserName);
        request.getClientInfo().setPassword("None");

        pickupCreationResponse = postForObject(URL, request, PickupCreationResponse.class);

        assertNotNull(pickupCreationResponse);
        assertTrue(pickupCreationResponse.getHasErrors());
        assertFalse(pickupCreationResponse.getNotifications().isEmpty());
        assertEquals("ERR01", pickupCreationResponse.getNotifications().get(0).getCode());
        assertEquals("ClientInfo - Invalid username or password", pickupCreationResponse.getNotifications().get(0).getMessage());
    }

    @Test
    public void testCreatePickup_invalidDates() throws Exception {
        //----------------------CLOSING & LAST PICKUP TIME > READY TIME-----------------------
        final PickupCreationRequest request = createPickupCreationRequest();

        String foreignHAWB = String.valueOf(System.currentTimeMillis());
        request.getPickup().getShipments().get(0).setForeignHAWB(foreignHAWB);

        LocalDateTime localDateTime = LocalDateTime.now();
        final long pickupDate = ZonedDateTime.of(localDateTime, ZoneId.systemDefault()).toInstant().toEpochMilli();
        request.getPickup().setPickupDate(String.format("%s%s%s", "/Date(" , pickupDate , "-0500)/"));
        long readyTime = ZonedDateTime.of(localDateTime.plusHours(3), ZoneId.systemDefault()).toInstant().toEpochMilli();
        request.getPickup().setReadyTime(String.format("%s%s%s", "/Date(" , readyTime , "-0500)/"));
        final long lastPickupTime = ZonedDateTime.of(localDateTime.plusYears(3).plusMinutes(10), ZoneId.systemDefault()).toInstant().toEpochMilli();
        request.getPickup().setLastPickupTime(String.format("%s%s%s", "/Date(" , lastPickupTime , "-0500)/"));
        final long closingTime = ZonedDateTime.of(localDateTime.plusYears(5), ZoneId.systemDefault()).toInstant().toEpochMilli();
        request.getPickup().setClosingTime(String.format("%s%s%s", "/Date(" , closingTime , "-0500)/"));

        PickupCreationResponse successfulResponse = createSuccessfulResponse();
        successfulResponse.getProcessedPickup().getProcessedShipments().get(0).setForeignHAWB(foreignHAWB);

        PickupCreationResponse pickupCreationResponse = postForObject(URL, request, PickupCreationResponse.class);

        assertNotNull(pickupCreationResponse);
        assertTrue(pickupCreationResponse.getHasErrors());
        assertFalse(pickupCreationResponse.getNotifications().isEmpty());
        assertEquals("ERR35", pickupCreationResponse.getNotifications().get(0).getCode());
        assertEquals("Closing Time should be greater than the Ready Time", pickupCreationResponse.getNotifications().get(0).getMessage());
        assertEquals("ERR36", pickupCreationResponse.getNotifications().get(1).getCode());
        assertEquals("Last Pickup Time should be greater than the Ready Time", pickupCreationResponse.getNotifications().get(1).getMessage());
        assertEquals("ERR37", pickupCreationResponse.getNotifications().get(2).getCode());
        assertEquals("Ready Time should be within the business hours of the entity", pickupCreationResponse.getNotifications().get(2).getMessage());

        //----------------------READY TIME > MIN LEAD TIME-----------------------
        readyTime = ZonedDateTime.of(localDateTime.minusHours(3), ZoneId.systemDefault()).toInstant().toEpochMilli();
        request.getPickup().setReadyTime(String.format("%s%s%s", "/Date(" , readyTime , "-0500)/"));

        successfulResponse = createSuccessfulResponse();
        successfulResponse.getProcessedPickup().getProcessedShipments().get(0).setForeignHAWB(foreignHAWB);

        pickupCreationResponse = postForObject(URL, request, PickupCreationResponse.class);

        assertNotNull(pickupCreationResponse);
        assertTrue(pickupCreationResponse.getHasErrors());
        assertFalse(pickupCreationResponse.getNotifications().isEmpty());
        assertEquals("ERR38", pickupCreationResponse.getNotifications().get(1).getCode());
        assertEquals("Ready Time is earlier than minimum lead time", pickupCreationResponse.getNotifications().get(1).getMessage());
    }

    @Test
    public void testCreatePickup_invalidForeignHAWB() throws Exception {
        final PickupCreationRequest request = createPickupCreationRequest();

        String foreignHAWB = String.valueOf(System.currentTimeMillis());
        request.getPickup().getShipments().get(0).setForeignHAWB(foreignHAWB);

        final PickupCreationResponse successfulResponse = createSuccessfulResponse();
        successfulResponse.getProcessedPickup().getProcessedShipments().get(0).setForeignHAWB(foreignHAWB);

        PickupCreationResponse pickupCreationResponse = postForObject(URL, request, PickupCreationResponse.class);

        assertNotNull(pickupCreationResponse);
        assertEquals(successfulResponse, pickupCreationResponse);

        pickupCreationResponse = postForObject(URL, request, PickupCreationResponse.class);

        assertNotNull(pickupCreationResponse);
        assertTrue(pickupCreationResponse.getProcessedPickup().getProcessedShipments().get(0).isHasErrors());
        assertFalse(pickupCreationResponse.getProcessedPickup().getProcessedShipments().get(0).getNotifications().isEmpty());
        assertEquals("ERR30", pickupCreationResponse.getProcessedPickup().getProcessedShipments().get(0).getNotifications().get(0).getCode());
        assertEquals("ForeignHAWB - Another shipment with the same Foreign AWB Number already exists", pickupCreationResponse.getProcessedPickup().getProcessedShipments().get(0).getNotifications().get(0).getMessage());
    }


    private PickupCreationRequest createPickupCreationRequest() throws JsonProcessingException {
        return objectMapper.readValue(REQUEST_JSON, PickupCreationRequest.class);
    }

    private PickupCreationResponse createSuccessfulResponse() throws JsonProcessingException {
        return objectMapper.readValue(RESPONSE_JSON, PickupCreationResponse.class);
    }
}
