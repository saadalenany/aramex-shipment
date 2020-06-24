package aramex.controller;

import aramex.models.calculate_rate.RateCalculatorRequest;
import aramex.models.calculate_rate.RateCalculatorResponse;
import aramex.models.create_shipment.ShipmentCreationRequest;
import aramex.models.create_shipment.ShipmentCreationResponse;
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

    @PostMapping("/calculate_rate")
    public ResponseEntity<RateCalculatorResponse> rateCalculator(@RequestBody RateCalculatorRequest rateCalculatorRequest) {
        return ResponseEntity.ok(shippingService.rateCalculator(rateCalculatorRequest));
    }

    @PostMapping("/create_shipment")
    public ResponseEntity<ShipmentCreationResponse> createShipment(@RequestBody ShipmentCreationRequest shipmentCreationRequest) {
        return ResponseEntity.ok(shippingService.createShipment(shipmentCreationRequest));
    }

}
