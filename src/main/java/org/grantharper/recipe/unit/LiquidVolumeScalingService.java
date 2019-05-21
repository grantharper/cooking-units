package org.grantharper.recipe.unit;

import javax.measure.Quantity;
import javax.measure.quantity.Volume;

import static org.grantharper.recipe.unit.CookingUnits.*;

public class LiquidVolumeScalingService extends ScalingServiceAbstract<Volume> {

    Quantity<Volume> convertToAppropriateUnit(Quantity<Volume> input) {

        if (input.getUnit().equals(CUP)) {
            System.out.println("Cup amount found");
            return convertCupsToAppropriateUnit(input);
        }
        if (input.getUnit().equals(FLUID_OUNCE)) {
            System.out.println("Fluid ounce amount found");
            return convertFlOzToAppropriateUnit(input);
        }
        return input;
    }

    private Quantity<Volume> convertCupsToAppropriateUnit(Quantity<Volume> input) {
        if (input.getValue().doubleValue() <= 0.0625) {
            return input.to(TEASPOON);
        } else if (input.getValue().doubleValue() <= 1.0) {
            return input.to(FLUID_OUNCE);
        }
        return input;
    }

    private Quantity<Volume> convertFlOzToAppropriateUnit(Quantity<Volume> input) {
        if (input.getValue().doubleValue() >= 8.0) {
            return input.to(CUP);
        } else if (input.getValue().doubleValue() < 1.0) {
            return input.to(TEASPOON);
        }
        return input;
    }

}
