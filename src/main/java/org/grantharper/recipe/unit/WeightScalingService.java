package org.grantharper.recipe.unit;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;

public class WeightScalingService extends ScalingServiceAbstract<Mass> {

    @Override
    Quantity<Mass> convertToAppropriateUnit(Quantity<Mass> input) {
        return null;
    }
}
