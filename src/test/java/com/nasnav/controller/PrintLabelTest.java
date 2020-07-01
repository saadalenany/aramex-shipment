package com.nasnav.controller;

import com.nasnav.BaseTest;
import com.nasnav.models.print_label.LabelPrintingRequest;
import com.nasnav.models.print_label.LabelPrintingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PrintLabelTest extends BaseTest {

    private static final String REQUEST_JSON = "{\"ClientInfo\":{\"UserName\":\"reem@reem.com\",\"Password\":\"123456789\",\"Version\":\"v1\",\"AccountNumber\":\"20016\",\"AccountPin\":\"331421\",\"AccountEntity\":\"AMM\",\"AccountCountryCode\":\"JO\",\"Source\":24},\"LabelInfo\":{\"ReportID\":9201,\"ReportType\":\"URL\"},\"OriginEntity\":\"AMM\",\"ProductGroup\":\"EXP\",\"ShipmentNumber\":\"3958011433\",\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"}}";

    private static final String RESPONSE_JSON = "{\"Transaction\":{\"Reference1\":\"\",\"Reference2\":\"\",\"Reference3\":\"\",\"Reference4\":\"\",\"Reference5\":\"\"},\"Notifications\":[],\"HasErrors\":false,\"ShipmentNumber\":\"3958011433\",\"ShipmentLabel\":{\"LabelURL\":\"http://www.sandbox.aramex.com/content/rpt_cache/85ef42ecca7845839f6b7a6528ce1574.pdf\",\"LabelFileContents\":\"\"}}";

    private static final String URL = "/shipping/print_label";

    @Test
    public void testLabelPrinting_success() throws Exception {
        final LabelPrintingRequest request = createRateRequest();
        final LabelPrintingResponse successfulResponse = createSuccessfulResponse();

        final LabelPrintingResponse response = postForObject(URL, request, LabelPrintingResponse.class);

        assertNotNull(response);
        assertEquals(successfulResponse, response);
    }

    @Test
    public void testLabelPrinting_invalidUsernameOrPassword() throws Exception {
        //---------------------TEST USERNAME-------------------
        final LabelPrintingRequest request = createRateRequest();
        String correctUserName = request.getClientInfo().getUserName();
        request.getClientInfo().setUserName("None");

        LabelPrintingResponse response = postForObject(URL, request, LabelPrintingResponse.class);

        assertNotNull(response);
        Assertions.assertTrue(response.getHasErrors());
        Assertions.assertFalse(response.getNotifications().isEmpty());
        Assertions.assertEquals("ERR01", response.getNotifications().get(0).getCode());
        Assertions.assertEquals("ClientInfo - Invalid username or password", response.getNotifications().get(0).getMessage());

        //---------------------TEST PASSWORD-------------------
        request.getClientInfo().setUserName(correctUserName);
        request.getClientInfo().setPassword("None");

        response = postForObject(URL, request, LabelPrintingResponse.class);

        assertNotNull(response);
        Assertions.assertEquals(Boolean.TRUE, response.getHasErrors());
        Assertions.assertFalse(response.getNotifications().isEmpty());
        Assertions.assertEquals("ERR01", response.getNotifications().get(0).getCode());
        Assertions.assertEquals("ClientInfo - Invalid username or password", response.getNotifications().get(0).getMessage());
    }

    @Test
    public void testLabelPrinting_invalidLabelInfo() throws Exception {
        //---------------------TEST LABEL INFO - Report ID-------------------
        LabelPrintingRequest request = createRateRequest();
        request.getLabelInfo().setReportId(0);

        LabelPrintingResponse response = postForObject(URL, request, LabelPrintingResponse.class);

        assertNotNull(response);
        Assertions.assertTrue(response.getHasErrors());
        Assertions.assertFalse(response.getNotifications().isEmpty());
        Assertions.assertEquals("ERR07", response.getNotifications().get(0).getCode());
        Assertions.assertEquals("LabelInfo.ReportID - Invalid Report ID", response.getNotifications().get(0).getMessage());

        //---------------------TEST LABEL INFO-------------------
        request = createRateRequest();
        request.setLabelInfo(null);

        response = postForObject(URL, request, LabelPrintingResponse.class);

        assertNotNull(response);
        Assertions.assertTrue(response.getHasErrors());
        Assertions.assertFalse(response.getNotifications().isEmpty());
        Assertions.assertEquals("REQ13", response.getNotifications().get(0).getCode());
        Assertions.assertEquals("LabelInfo - Label Info is empty", response.getNotifications().get(0).getMessage());
    }

    @Test
    public void testLabelPrinting_invalidShipmentNumber() throws Exception {
        //---------------------TEST SHIPMENT NUMBER-------------------
        LabelPrintingRequest request = createRateRequest();
        request.setShipmentNumber(null);

        LabelPrintingResponse response = postForObject(URL, request, LabelPrintingResponse.class);

        assertNotNull(response);
        Assertions.assertTrue(response.getHasErrors());
        Assertions.assertFalse(response.getNotifications().isEmpty());
        Assertions.assertEquals("REQ15", response.getNotifications().get(0).getCode());
        Assertions.assertEquals("ShipmentNumber - Shipment Number is empty", response.getNotifications().get(0).getMessage());
    }


    private LabelPrintingResponse createSuccessfulResponse() throws JsonProcessingException {
        return objectMapper.readValue(RESPONSE_JSON, LabelPrintingResponse.class);
    }

    private LabelPrintingRequest createRateRequest() throws JsonProcessingException {
        return objectMapper.readValue(REQUEST_JSON, LabelPrintingRequest.class);
    }
}
