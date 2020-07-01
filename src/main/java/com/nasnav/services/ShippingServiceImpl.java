package com.nasnav.services;

import com.nasnav.models.Request;
import com.nasnav.models.calculate_rate.RateCalculatorRequest;
import com.nasnav.models.calculate_rate.RateCalculatorResponse;
import com.nasnav.models.create_shipment.ShipmentCreationRequest;
import com.nasnav.models.create_shipment.ShipmentCreationResponse;
import com.nasnav.models.pickup.PickupCancellationRequest;
import com.nasnav.models.pickup.PickupCancellationResponse;
import com.nasnav.models.pickup.PickupCreationRequest;
import com.nasnav.models.pickup.PickupCreationResponse;
import com.nasnav.models.print_label.LabelPrintingRequest;
import com.nasnav.models.print_label.LabelPrintingResponse;
import com.nasnav.models.scheduled_delivery.ScheduledDeliveryRequest;
import com.nasnav.models.scheduled_delivery.ScheduledDeliveryResponse;
import com.nasnav.models.shipment_range.ShipmentNumberRangeRequest;
import com.nasnav.models.shipment_range.ShipmentNumberRangeResponse;
import com.nasnav.services.api.ShippingService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShippingServiceImpl implements ShippingService {

    private static final String URL_RATE_CALCULATOR = "https://ws.dev.aramex.net/ShippingAPI.V2/RateCalculator/Service_1_0.svc/json/CalculateRate";

    private static final String URL_CREATE_SHIPMENT = "https://ws.dev.aramex.net/ShippingAPI.V2/Shipping/Service_1_0.svc/json/CreateShipments";

    private static final String URL_PRINT_LABEL = "https://ws.dev.aramex.net/ShippingAPI.V2/Shipping/Service_1_0.svc/json/PrintLabel";

    private static final String URL_CREATE_PICKUP = "https://ws.dev.aramex.net/ShippingAPI.V2/Shipping/Service_1_0.svc/json/CreatePickup";

    private static final String URL_CANCEL_PICKUP = "https://ws.dev.aramex.net/ShippingAPI.V2/Shipping/Service_1_0.svc/json/CancelPickup";

    private static final String URL_RESERVE_SHIPMENT = "https://ws.dev.aramex.net/ShippingAPI.V2/Shipping/Service_1_0.svc/json/ReserveShipmentNumberRange";

    private static final String URL_GET_LAST_SHIPMENT = "https://ws.dev.aramex.net/ShippingAPI.V2/Shipping/Service_1_0.svc/json/GetLastShipmentsNumbersRange";

    private static final String URL_SCHEDULE_DELIVERY = "https://ws.dev.aramex.net/ShippingAPI.V2/Shipping/Service_1_0.svc/json/ScheduleDelivery";

    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    @Override
    public RateCalculatorResponse rateCalculator(RateCalculatorRequest rateCalculatorRequest) {
        return processRequestAndReturnResponse(URL_RATE_CALCULATOR, rateCalculatorRequest, RateCalculatorResponse.class);
    }

    @Override
    public ShipmentCreationResponse createShipment(ShipmentCreationRequest shipmentCreationRequest) {
        return processRequestAndReturnResponse(URL_CREATE_SHIPMENT, shipmentCreationRequest, ShipmentCreationResponse.class);
    }

    @Override
    public LabelPrintingResponse printLabel(LabelPrintingRequest labelPrintingRequest) {
        return processRequestAndReturnResponse(URL_PRINT_LABEL, labelPrintingRequest, LabelPrintingResponse.class);
    }

    @Override
    public PickupCreationResponse createPickup(PickupCreationRequest pickupCreationRequest) {
        return processRequestAndReturnResponse(URL_CREATE_PICKUP, pickupCreationRequest, PickupCreationResponse.class);
    }

    @Override
    public PickupCancellationResponse cancelPickup(PickupCancellationRequest pickupCancellationRequest) {
        return processRequestAndReturnResponse(URL_CANCEL_PICKUP, pickupCancellationRequest, PickupCancellationResponse.class);
    }

    @Override
    public ShipmentNumberRangeResponse reserveShipment(ShipmentNumberRangeRequest shipmentNumberRangeRequest) {
        return processRequestAndReturnResponse(URL_RESERVE_SHIPMENT, shipmentNumberRangeRequest, ShipmentNumberRangeResponse.class);
    }

    @Override
    public ShipmentNumberRangeResponse getLastShipment(ShipmentNumberRangeRequest shipmentNumberRangeRequest) {
        return processRequestAndReturnResponse(URL_GET_LAST_SHIPMENT, shipmentNumberRangeRequest, ShipmentNumberRangeResponse.class);
    }

    @Override
    public ScheduledDeliveryResponse scheduleDelivery(ScheduledDeliveryRequest scheduledDeliveryRequest) {
        return processRequestAndReturnResponse(URL_SCHEDULE_DELIVERY, scheduledDeliveryRequest, ScheduledDeliveryResponse.class);
    }

    private <T> T processRequestAndReturnResponse(String url, Request data, Class<T> response) {
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Data attached to the request.
        HttpEntity<Request> requestBody = new HttpEntity<>(data, headers);

        // Send request with POST method.
        ResponseEntity<T> result = restTemplate.postForEntity(url, requestBody, response);

        return result.getBody();
    }
}
