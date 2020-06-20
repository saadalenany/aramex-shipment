package aramex.controller;

import aramex.models.RateCalculatorRequest;
import aramex.models.RateCalculatorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ShippingControllerTest {

    private final static String RATE_REQUEST_JSON = "{\"ClientInfo\":{\"UserName\":\"reem@reem.com\",\"Password\":\"123456789\",\"Version\":\"v1\",\"AccountNumber\":\"20016\",\"AccountPin\":\"331421\",\"AccountEntity\":\"AMM\",\"AccountCountryCode\":\"JO\",\"Source\":24},\"DestinationAddress\":{\"Line1\":\"XYZ Street\",\"Line2\":\"Unit # 1\",\"Line3\":\"\",\"City\":\"Dubai\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"AE\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"OriginAddress\":{\"Line1\":\"ABC Street\",\"Line2\":\"Unit # 1\",\"Line3\":\"\",\"City\":\"Amman\",\"StateOrProvinceCode\":\"\",\"PostCode\":\"\",\"CountryCode\":\"JO\",\"Longitude\":0,\"Latitude\":0,\"BuildingNumber\":null,\"BuildingName\":null,\"Floor\":null,\"Apartment\":null,\"POBox\":null,\"Description\":null},\"PreferredCurrencyCode\":\"USD\",\"ShipmentDetails\":{\"Dimensions\":null,\"ActualWeight\":{\"Unit\":\"KG\",\"Value\":1},\"ChargeableWeight\":null,\"DescriptionOfGoods\":null,\"GoodsOriginCountry\":null,\"NumberOfPieces\":1,\"ProductGroup\":\"EXP\",\"ProductType\":\"PPX\",\"PaymentType\":\"P\",\"PaymentOptions\":\"\",\"CustomsValueAmount\":null,\"CashOnDeliveryAmount\":null,\"InsuranceAmount\":null,\"CashAdditionalAmount\":null,\"CashAdditionalAmountDescription\":null,\"CollectAmount\":null,\"Services\":\"\",\"Items\":null,\"DeliveryInstructions\":null},\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"}}";

    private final static String RATE_RESPONSE_JSON = "{\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"},\"Notifications\":[],\"HasErrors\":false,\"TotalAmount\":{\"CurrencyCode\":\"USD\",\"Value\":342.25},\"RateDetails\":{\"Amount\":85.18,\"OtherAmount1\":0,\"OtherAmount2\":0,\"OtherAmount3\":21.3,\"OtherAmount4\":0,\"OtherAmount5\":188.56,\"TotalAmountBeforeTax\":295.04,\"TaxAmount\":47.21}}";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRateCalculator_success() throws Exception {
        final RateCalculatorRequest rateRequest = createRateRequest();
        final RateCalculatorResponse successfulResponse = createSuccessfulResponse();

        final RateCalculatorResponse rateCalculatorResponse = postForObject("/shipping/rate", rateRequest, RateCalculatorResponse.class);

        assertNotNull(rateCalculatorResponse);
        assertEquals(successfulResponse, rateCalculatorResponse);
    }

    @Test
    public void testRateCalculator_invalidUsernameOrPassword() throws Exception {
        //---------------------TEST USERNAME-------------------
        final RateCalculatorRequest rateRequest = createRateRequest();
        String correctUserName = rateRequest.getClientInfo().getUserName();
        rateRequest.getClientInfo().setUserName("None");

        RateCalculatorResponse rateCalculatorResponse = postForObject("/shipping/rate", rateRequest, RateCalculatorResponse.class);

        assertNotNull(rateCalculatorResponse);
        assertEquals(Boolean.TRUE, rateCalculatorResponse.getHasErrors());
        assertFalse(rateCalculatorResponse.getNotifications().isEmpty());
        assertEquals("ERR01", rateCalculatorResponse.getNotifications().get(0).getCode());
        assertEquals("ClientInfo - Invalid username or password", rateCalculatorResponse.getNotifications().get(0).getMessage());

        //---------------------TEST PASSWORD-------------------
        rateRequest.getClientInfo().setUserName(correctUserName);
        rateRequest.getClientInfo().setPassword("None");

        rateCalculatorResponse = postForObject("/shipping/rate", rateRequest, RateCalculatorResponse.class);

        assertNotNull(rateCalculatorResponse);
        assertEquals(Boolean.TRUE, rateCalculatorResponse.getHasErrors());
        assertFalse(rateCalculatorResponse.getNotifications().isEmpty());
        assertEquals("ERR01", rateCalculatorResponse.getNotifications().get(0).getCode());
        assertEquals("ClientInfo - Invalid username or password", rateCalculatorResponse.getNotifications().get(0).getMessage());
    }

    @Test
    public void testRateCalculator_invalidAddress() throws Exception {
        final RateCalculatorRequest rateRequest = createRateRequest();
        rateRequest.setDestinationAddress(null);
        rateRequest.setOriginAddress(null);

        final RateCalculatorResponse rateCalculatorResponse = postForObject("/shipping/rate", rateRequest, RateCalculatorResponse.class);

        assertNotNull(rateCalculatorResponse);
        assertEquals(Boolean.TRUE, rateCalculatorResponse.getHasErrors());
        assertFalse(rateCalculatorResponse.getNotifications().isEmpty());
        assertEquals("OriginAddress - Address is empty", rateCalculatorResponse.getNotifications().get(0).getMessage());
        assertEquals("DestinationAddress - Address is empty", rateCalculatorResponse.getNotifications().get(1).getMessage());
    }

    @Test
    public void testRateCalculator_invalidShipmentDetails() throws Exception {
        final RateCalculatorRequest rateRequest = createRateRequest();
        rateRequest.setShipmentDetails(null);

        final RateCalculatorResponse rateCalculatorResponse = postForObject("/shipping/rate", rateRequest, RateCalculatorResponse.class);

        assertNotNull(rateCalculatorResponse);
        assertEquals(Boolean.TRUE, rateCalculatorResponse.getHasErrors());
        assertFalse(rateCalculatorResponse.getNotifications().isEmpty());
        assertEquals("ShipmentDetails - Missing Shipment Details", rateCalculatorResponse.getNotifications().get(0).getMessage());
    }

    private RateCalculatorResponse createSuccessfulResponse() throws JsonProcessingException {
        return objectMapper.readValue(RATE_RESPONSE_JSON, RateCalculatorResponse.class);
    }

    private RateCalculatorRequest createRateRequest() throws JsonProcessingException {
        return objectMapper.readValue(RATE_REQUEST_JSON, RateCalculatorRequest.class);
    }

    private <T> T postForObject(String url, Object data, Class<T> cls) throws Exception {
        String content = this.mockMvc.perform(
                post(url).params(new LinkedMultiValueMap<>()).content(objectMapper.writeValueAsBytes(data)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        return objectMapper.readValue(content, cls);
    }
}
