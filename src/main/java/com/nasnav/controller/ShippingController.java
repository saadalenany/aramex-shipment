package com.nasnav.controller;

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

    @PostMapping("/schedule_delivery")
    public ResponseEntity<ScheduledDeliveryResponse> scheduleDelivery(@RequestBody ScheduledDeliveryRequest scheduledDeliveryRequest) {
        return ResponseEntity.ok(shippingService.scheduleDelivery(scheduledDeliveryRequest));
    }
}
