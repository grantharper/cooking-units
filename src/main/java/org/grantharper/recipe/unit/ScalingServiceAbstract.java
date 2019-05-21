package org.grantharper.recipe.unit;

import javax.measure.Quantity;

public abstract class ScalingServiceAbstract<T extends Quantity<T>> implements ScalingService<T> {

    public Quantity<T> scale(Quantity<T> input, double scalingFactor) {
        if (scalingFactor < 1.0) {
            return convertToAppropriateUnit(input.divide(1.0 / scalingFactor));
        } else if (scalingFactor > 1.0) {
            return convertToAppropriateUnit(input.multiply(scalingFactor));
        }
        return input;
    }

    abstract Quantity<T> convertToAppropriateUnit(Quantity<T> input);


}
