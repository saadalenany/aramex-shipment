package aramex.services.api;

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

public interface ShippingService {

    public RateCalculatorResponse rateCalculator(RateCalculatorRequest rateCalculatorRequest);

    public ShipmentCreationResponse createShipment(ShipmentCreationRequest shipmentCreationRequest);

    public LabelPrintingResponse printLabel(LabelPrintingRequest labelPrintingRequest);

    public PickupCreationResponse createPickup(PickupCreationRequest pickupCreationRequest);

    public PickupCancellationResponse cancelPickup(PickupCancellationRequest pickupCancellationRequest);
}
