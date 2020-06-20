package aramex.controller;

import aramex.models.RateCalculatorRequest;
import aramex.models.RateCalculatorResponse;
import aramex.services.api.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/rate")
    public ResponseEntity<RateCalculatorResponse> rateCalculator(@RequestBody RateCalculatorRequest rateCalculatorRequest) {
        return ResponseEntity.ok(shippingService.rateCalculator(rateCalculatorRequest));
    }
}
