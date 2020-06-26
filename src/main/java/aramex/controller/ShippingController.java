package aramex.controller;

import aramex.models.calculate_rate.RateCalculatorRequest;
import aramex.models.calculate_rate.RateCalculatorResponse;
import aramex.models.create_shipment.ShipmentCreationRequest;
import aramex.models.create_shipment.ShipmentCreationResponse;
import aramex.models.pickup.PickupCancellationRequest;
import aramex.models.pickup.PickupCancellationResponse;
import aramex.models.pickup.PickupCreationRequest;
import aramex.models.pickup.PickupCreationResponse;
import aramex.models.print_label.LabelPrintingRequest;
import aramex.models.print_label.LabelPrintingResponse;
import aramex.models.shipment_range.ShipmentNumberRangeRequest;
import aramex.models.shipment_range.ShipmentNumberRangeResponse;
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

    @PostMapping("/print_label")
    public ResponseEntity<LabelPrintingResponse> printLabel(@RequestBody LabelPrintingRequest labelPrintingRequest) {
        return ResponseEntity.ok(shippingService.printLabel(labelPrintingRequest));
    }

    @PostMapping("/create_pickup")
    public ResponseEntity<PickupCreationResponse> createPickup(@RequestBody PickupCreationRequest pickupCreationRequest) {
        return ResponseEntity.ok(shippingService.createPickup(pickupCreationRequest));
    }

    @PostMapping("/cancel_pickup")
    public ResponseEntity<PickupCancellationResponse> cancelPickup(@RequestBody PickupCancellationRequest pickupCancellationRequest) {
        return ResponseEntity.ok(shippingService.cancelPickup(pickupCancellationRequest));
    }

    @PostMapping("/reserve_shipment")
    public ResponseEntity<ShipmentNumberRangeResponse> reserveShipment(@RequestBody ShipmentNumberRangeRequest shipmentNumberRangeRequest) {
        return ResponseEntity.ok(shippingService.reserveShipment(shipmentNumberRangeRequest));
    }

    @PostMapping("/last_shipment")
    public ResponseEntity<ShipmentNumberRangeResponse> getLastShipment(@RequestBody ShipmentNumberRangeRequest shipmentNumberRangeRequest) {
        return ResponseEntity.ok(shippingService.getLastShipment(shipmentNumberRangeRequest));
    }
}
