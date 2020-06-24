package aramex.services.api;

import aramex.models.calculate_rate.RateCalculatorRequest;
import aramex.models.calculate_rate.RateCalculatorResponse;
import aramex.models.create_shipment.ShipmentCreationRequest;
import aramex.models.create_shipment.ShipmentCreationResponse;

public interface ShippingService {

    public RateCalculatorResponse rateCalculator(RateCalculatorRequest rateCalculatorRequest);

    public ShipmentCreationResponse createShipment(ShipmentCreationRequest shipmentCreationRequest);
}
