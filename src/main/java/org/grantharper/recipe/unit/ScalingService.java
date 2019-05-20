package org.grantharper.recipe.unit;

import javax.measure.Quantity;

public interface ScalingService<T extends Quantity<T>> {

    Quantity<T> scale(Quantity<T> input, double scalingFactor);

}
