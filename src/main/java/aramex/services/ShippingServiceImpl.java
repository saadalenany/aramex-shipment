package aramex.services;

import aramex.models.RateCalculatorRequest;
import aramex.models.RateCalculatorResponse;
import aramex.services.api.ShippingService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Override
    public RateCalculatorResponse rateCalculator(RateCalculatorRequest rateCalculatorRequest) {
        String URL_CALCULATE_RATE = "https://ws.dev.aramex.net/ShippingAPI.V2/RateCalculator/Service_1_0.svc/json/CalculateRate";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Data attached to the request.
        HttpEntity<RateCalculatorRequest> requestBody = new HttpEntity<>(rateCalculatorRequest, headers);

        // Send request with POST method.
        ResponseEntity<RateCalculatorResponse> result = restTemplate.postForEntity(URL_CALCULATE_RATE, requestBody, RateCalculatorResponse.class);

        return result.getBody();
    }
}
