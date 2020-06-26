package aramex.controller;

import aramex.BaseTest;
import aramex.models.reserve_shipment.RangeReservationRequest;
import aramex.models.reserve_shipment.RangeReservationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReserveShipmentTest extends BaseTest {

    private static final String REQUEST_JSON = "{\"ClientInfo\":{\"UserName\":\"reem@reem.com\",\"Password\":\"123456789\",\"Version\":\"v1\",\"AccountNumber\":\"20016\",\"AccountPin\":\"331421\",\"AccountEntity\":\"AMM\",\"AccountCountryCode\":\"JO\",\"Source\":24},\"Count\":1000,\"Entity\":\"AMM\",\"ProductGroup\":\"EXP\",\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"}}";

    private static final String URL = "/shipping/reserve_shipment";

    @Test
    public void testRangeReservation_success() throws Exception {
        final RangeReservationRequest request = createRequest();

        final RangeReservationResponse response = postForObject(URL, request, RangeReservationResponse.class);

        assertNotNull(response);
        assertFalse(response.getHasErrors());
        assertNotNull(response.getFromWayBill());
        assertNotNull(response.getToWayBill());
    }

    @Test
    public void testRangeReservation_invalidUsernameOrPassword() throws Exception {
        //---------------------TEST USERNAME-------------------
        final RangeReservationRequest request = createRequest();
        String correctUserName = request.getClientInfo().getUserName();
        request.getClientInfo().setUserName("None");

        RangeReservationResponse response = postForObject(URL, request, RangeReservationResponse.class);

        assertNotNull(response);
        assertTrue(response.getHasErrors());
        assertFalse(response.getNotifications().isEmpty());
        assertEquals("ERR01", response.getNotifications().get(0).getCode());
        assertEquals("ClientInfo - Invalid username or password", response.getNotifications().get(0).getMessage());

        //---------------------TEST PASSWORD-------------------
        request.getClientInfo().setUserName(correctUserName);
        request.getClientInfo().setPassword("None");

        response = postForObject(URL, request, RangeReservationResponse.class);

        assertNotNull(response);
        assertEquals(Boolean.TRUE, response.getHasErrors());
        assertFalse(response.getNotifications().isEmpty());
        assertEquals("ERR01", response.getNotifications().get(0).getCode());
        assertEquals("ClientInfo - Invalid username or password", response.getNotifications().get(0).getMessage());
    }

    private RangeReservationRequest createRequest() throws JsonProcessingException {
        return objectMapper.readValue(REQUEST_JSON, RangeReservationRequest.class);
    }
}
