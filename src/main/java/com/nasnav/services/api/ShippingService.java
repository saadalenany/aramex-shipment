package com.nasnav.services.api;

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

public interface ShippingService {

    public RateCalculatorResponse rateCalculator(RateCalculatorRequest rateCalculatorRequest);

    public ShipmentCreationResponse createShipment(ShipmentCreationRequest shipmentCreationRequest);

    public LabelPrintingResponse printLabel(LabelPrintingRequest labelPrintingRequest);

    public PickupCreationResponse createPickup(PickupCreationRequest pickupCreationRequest);

    public PickupCancellationResponse cancelPickup(PickupCancellationRequest pickupCancellationRequest);

    public ShipmentNumberRangeResponse reserveShipment(ShipmentNumberRangeRequest shipmentNumberRangeRequest);

    public ShipmentNumberRangeResponse getLastShipment(ShipmentNumberRangeRequest shipmentNumberRangeRequest);

    public ScheduledDeliveryResponse scheduleDelivery(ScheduledDeliveryRequest scheduledDeliveryRequest);
}
