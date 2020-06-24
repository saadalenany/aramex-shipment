package aramex.services;

import aramex.models.calculate_rate.RateCalculatorRequest;
import aramex.models.calculate_rate.RateCalculatorResponse;
import aramex.models.create_shipment.ShipmentCreationRequest;
import aramex.models.create_shipment.ShipmentCreationResponse;
import aramex.services.api.ShippingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShippingServiceImpl implements ShippingService {

    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    @Override
    public RateCalculatorResponse rateCalculator(RateCalculatorRequest rateCalculatorRequest) {
        String URL_CALCULATE_RATE = "https://ws.dev.aramex.net/ShippingAPI.V2/RateCalculator/Service_1_0.svc/json/CalculateRate";

        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Data attached to the request.
        HttpEntity<RateCalculatorRequest> requestBody = new HttpEntity<>(rateCalculatorRequest, headers);

        // Send request with POST method.
        ResponseEntity<RateCalculatorResponse> result = restTemplate.postForEntity(URL_CALCULATE_RATE, requestBody, RateCalculatorResponse.class);

        return result.getBody();
    }

    @Override
    public ShipmentCreationResponse createShipment(ShipmentCreationRequest shipmentCreationRequest) {
        String URL_CREATE_SHIPMENT = "https://ws.dev.aramex.net/ShippingAPI.V2/Shipping/Service_1_0.svc/json/CreateShipments";

        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Data attached to the request.
        HttpEntity<ShipmentCreationRequest> requestBody = new HttpEntity<>(shipmentCreationRequest, headers);

        // Send request with POST method.
        ResponseEntity<ShipmentCreationResponse> result = restTemplate.postForEntity(URL_CREATE_SHIPMENT, requestBody, ShipmentCreationResponse.class);

        return result.getBody();
    }
}
