package com.nasnav.controller;

import com.nasnav.BaseTest;
import com.nasnav.models.pickup.PickupCancellationRequest;
import com.nasnav.models.pickup.PickupCancellationResponse;
import com.nasnav.models.pickup.PickupCreationRequest;
import com.nasnav.models.pickup.PickupCreationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CancelPickupTest extends BaseTest {

    private static final String CREATE_REQUEST_JSON = "{\"ClientInfo\":{\"UserName\":\"testingapi@aramex.com\",\"Password\":\"R123456789$r\",\"Version\":\"v1\",\"AccountNumber\":\"20016\",\"AccountPin\":\"331421\",\"AccountEntity\":\"AMM\",\"AccountCountryCode\":\"JO\",\"Source\":24},\"LabelInfo\":{\"ReportID\":9201,\"ReportType\":\"URL\"},\"Pickup\":{\"PickupAddress\":{\"Line1\":\"Test\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"Amman\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"JO\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"PickupContact\":{\"Department\":\"\",\"PersonName\":\"test\",\"Title\":\"\",\"CompanyName\":\"test\",\"PhoneNumber1\":\"1111111111111\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"11111111111111\",\"EmailAddress\":\"test@test.com\",\"Type\":\"\"},\"PickupLocation\":\"test\",\"PickupDate\":\"/Date(1593119257529-0500)/\",\"ReadyTime\":\"/Date(1693118259529-0500)/\",\"LastPickupTime\":\"/Date(1693118269529-0500)/\",\"ClosingTime\":\"/Date(1793118257529-0500)/\",\"Comments\":\"\",\"Reference1\":\"001\",\"Reference2\":\"\",\"Vehicle\":\"\",\"Shipments\":[{\"Reference1\":\"123\",\"Reference2\":\"\",\"Reference3\":\"\",\"Shipper\":{\"Reference1\":\"\",\"Reference2\":\"\",\"AccountNumber\":\"20016\",\"PartyAddress\":{\"Line1\":\"Test\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"Amman\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"JO\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"Contact\":{\"Department\":\"\",\"PersonName\":\"Test\",\"Title\":\"\",\"CompanyName\":\"Test\",\"PhoneNumber1\":\"5555\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"5555\",\"EmailAddress\":\"m@m.com\",\"Type\":\"\"}},\"Consignee\":{\"Reference1\":\"\",\"Reference2\":\"\",\"AccountNumber\":\"\",\"PartyAddress\":{\"Line1\":\"Test\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"Dubai\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"AE\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":\"\",\"BuildingName\":\"\",\"Floor\":\"\",\"Apartment\":\"\",\"POBox\":null,\"Description\":\"\"},\"Contact\":{\"Department\":\"\",\"PersonName\":\"Test\",\"Title\":\"\",\"CompanyName\":\"Test\",\"PhoneNumber1\":\"555\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"555\",\"EmailAddress\":\"f@f.com\",\"Type\":\"\"}},\"ThirdParty\":{\"Reference1\":\"\",\"Reference2\":\"\",\"AccountNumber\":\"\",\"PartyAddress\":{\"Line1\":\"\",\"Line2\":\"\",\"Line3\":\"\",\"City\":\"\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"Contact\":{\"Department\":\"\",\"PersonName\":\"\",\"Title\":\"\",\"CompanyName\":\"\",\"PhoneNumber1\":\"\",\"PhoneNumber1Ext\":\"\",\"PhoneNumber2\":\"\",\"PhoneNumber2Ext\":\"\",\"FaxNumber\":\"\",\"CellPhone\":\"\",\"EmailAddress\":\"\",\"Type\":\"\"}},\"ShippingDateTime\":\"/Date(1593138492805-0500)/\",\"DueDate\":\"/Date(1593138492805-0500)/\",\"Comments\":\"Comments ...\",\"PickupLocation\":\"Reception\",\"OperationsInstructions\":\"Fragile\",\"AccountingInstrcutions\":\"Get us a discount please\",\"Details\":{\"Dimensions\":null,\"ActualWeight\":{\"Unit\":\"KG\",\"Value\":0.5},\"ChargeableWeight\":null,\"DescriptionOfGoods\":\"Docs\",\"GoodsOriginCountry\":\"JO\",\"NumberOfPieces\":1,\"ProductGroup\":\"EXP\",\"ProductType\":\"PDX\",\"PaymentType\":\"P\",\"PaymentOptions\":\"\",\"CustomsValueAmount\":null,\"CashOnDeliveryAmount\":null,\"InsuranceAmount\":null,\"CashAdditionalAmount\":null,\"CashAdditionalAmountDescription\":\"\",\"CollectAmount\":null,\"Services\":\"\",\"Items\":[],\"DeliveryInstructions\":null},\"Attachments\":[],\"ForeignHAWB\":\"12212121212222\",\"TransportType\":0,\"PickupGUID\":null,\"Number\":\"\"}],\"PickupItems\":[{\"ProductGroup\":\"EXP\",\"ProductType\":\"PDX\",\"NumberOfShipments\":1,\"PackageType\":\"Box\",\"Payment\":\"P\",\"ShipmentWeight\":{\"Unit\":\"KG\",\"Value\":0.5},\"ShipmentVolume\":null,\"NumberOfPieces\":1,\"CashAmount\":null,\"ExtraCharges\":null,\"ShipmentDimensions\":{\"Length\":0,\"Width\":0,\"Height\":0,\"Unit\":\"\"},\"Comments\":\"Test\"}],\"Status\":\"Ready\",\"ExistingShipments\":null,\"Branch\":\"\",\"RouteCode\":\"\"},\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"}}";

    private static final String CREATE_RESPONSE_JSON = "{\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"},\"Notifications\":[],\"HasErrors\":false,\"ProcessedPickup\":{\"ID\":\"F261B9C\",\"GUID\":\"23877685-c680-4bb0-961f-0b430b5b06ee\",\"Reference1\":\"001\",\"Reference2\":\"\",\"ProcessedShipments\":[{\"ID\":\"32615496642\",\"Reference1\":\"123\",\"Reference2\":\"\",\"Reference3\":\"\",\"ForeignHAWB\":\"12212121212222\",\"HasErrors\":false,\"Notifications\":[],\"ShipmentLabel\":{\"LabelURL\":\"http://www.sandbox.aramex.com/content/rpt_cache/ed230a846ff74b99a3dd473882c60c3f.pdf\",\"LabelFileContents\":\"\"},\"ShipmentDetails\":{\"Dimensions\":null,\"ActualWeight\":null,\"ChargeableWeight\":{\"Unit\":\"KG\",\"Value\":0.5},\"DescriptionOfGoods\":\"Docs\",\"GoodsOriginCountry\":\"JO\",\"NumberOfPieces\":1,\"ProductGroup\":\"EXP\",\"ProductType\":\"PDX\",\"PaymentType\":\"P\",\"PaymentOptions\":\"\",\"DeliveryInstructions\":null,\"CustomsValueAmount\":null,\"CashOnDeliveryAmount\":null,\"InsuranceAmount\":null,\"CashAdditionalAmount\":null,\"CashAdditionalAmountDescription\":null,\"CollectAmount\":null,\"Services\":\"\",\"Items\":null},\"ShipmentAttachments\":[]}]}}";

    private static final String CANCEL_REQUEST_JSON = "{\"ClientInfo\":{\"UserName\":\"reem@reem.com\",\"Password\":\"123456789\",\"Version\":\"v1\",\"AccountNumber\":\"20016\",\"AccountPin\":\"331421\",\"AccountEntity\":\"AMM\",\"AccountCountryCode\":\"JO\",\"Source\":24},\"Comments\":\"Test\",\"PickupGUID\":\"8e119eb2-c8f1-4640-a9e3-01d8bb904df0\",\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"}}";

    private static final String CANCEL_RESPONSE_JSON = "{\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"},\"Notifications\":[],\"HasErrors\":false,\"Message\":\"The pickup has been canceled successfully\"}";

    private static final String CREATE_URL = "/shipping/create_pickup";

    private static final String CANCEL_URL = "/shipping/cancel_pickup";

    @Test
    public void testCreatePickup_success() throws Exception {
        //------------------CREATE PICKUP------------------------
        final PickupCreationRequest pickupCreationRequest = createPickupCreationRequest();

        String foreignHAWB = String.valueOf(System.currentTimeMillis());
        pickupCreationRequest.getPickup().getShipments().get(0).setForeignHAWB(foreignHAWB);

        final PickupCreationResponse successfulCreationResponse = createPickupCreationResponse();
        successfulCreationResponse.getProcessedPickup().getProcessedShipments().get(0).setForeignHAWB(foreignHAWB);

        final PickupCreationResponse pickupCreationResponse = postForObject(CREATE_URL, pickupCreationRequest, PickupCreationResponse.class);

        assertNotNull(pickupCreationResponse);
        assertEquals(successfulCreationResponse, pickupCreationResponse);

        //------------------CANCEL PICKUP------------------------
        final PickupCancellationRequest request = createPickupCancellationRequest();
        request.setPickupGuid(pickupCreationResponse.getProcessedPickup().getGuid());

        final PickupCancellationResponse successfulResponse = createPickupCancellationResponse();

        final PickupCancellationResponse cancellationResponse = postForObject(CANCEL_URL, request, PickupCancellationResponse.class);

        assertNotNull(cancellationResponse);
        assertEquals(successfulResponse, cancellationResponse);
    }

    @Test
    public void testCreatePickup_failure() throws Exception {
        //------------------CREATE PICKUP------------------------
        final PickupCreationRequest pickupCreationRequest = createPickupCreationRequest();

        String foreignHAWB = String.valueOf(System.currentTimeMillis());
        pickupCreationRequest.getPickup().getShipments().get(0).setForeignHAWB(foreignHAWB);

        final PickupCreationResponse successfulCreationResponse = createPickupCreationResponse();
        successfulCreationResponse.getProcessedPickup().getProcessedShipments().get(0).setForeignHAWB(foreignHAWB);

        final PickupCreationResponse pickupCreationResponse = postForObject(CREATE_URL, pickupCreationRequest, PickupCreationResponse.class);

        assertNotNull(pickupCreationResponse);
        assertEquals(successfulCreationResponse, pickupCreationResponse);

        //------------------CANCEL PICKUP------------------------
        final PickupCancellationRequest request = createPickupCancellationRequest();
        request.setPickupGuid(pickupCreationResponse.getProcessedPickup().getGuid());

        final PickupCancellationResponse successfulResponse = createPickupCancellationResponse();

        PickupCancellationResponse cancellationResponse = postForObject(CANCEL_URL, request, PickupCancellationResponse.class);

        assertNotNull(cancellationResponse);
        assertEquals(successfulResponse, cancellationResponse);

        //------------------CANCEL PICKUP------------------------
        cancellationResponse = postForObject(CANCEL_URL, request, PickupCancellationResponse.class);

        assertNotNull(cancellationResponse);
        assertTrue(cancellationResponse.getHasErrors());
        assertEquals("The pickup has encountered some issues while canceling. Please refer to the list of notifications for more details.", cancellationResponse.getMessage());
        assertEquals("ERR70",cancellationResponse.getNotifications().get(0).getCode());
        assertEquals("PickupGUID - Cannot cancel a cancelled pickup",cancellationResponse.getNotifications().get(0).getMessage());
    }

    private PickupCancellationResponse createPickupCancellationResponse() throws Exception{
        return objectMapper.readValue(CANCEL_RESPONSE_JSON, PickupCancellationResponse.class);
    }

    private PickupCancellationRequest createPickupCancellationRequest() throws Exception{
        return objectMapper.readValue(CANCEL_REQUEST_JSON, PickupCancellationRequest.class);
    }

    private PickupCreationRequest createPickupCreationRequest() throws JsonProcessingException {
        return objectMapper.readValue(CREATE_REQUEST_JSON, PickupCreationRequest.class);
    }

    private PickupCreationResponse createPickupCreationResponse() throws JsonProcessingException {
        return objectMapper.readValue(CREATE_RESPONSE_JSON, PickupCreationResponse.class);
    }
}
