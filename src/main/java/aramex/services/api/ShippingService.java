package aramex.services.api;

import aramex.models.RateCalculatorRequest;
import aramex.models.RateCalculatorResponse;

public interface ShippingService {

    public RateCalculatorResponse rateCalculator(RateCalculatorRequest rateCalculatorRequest);

}
