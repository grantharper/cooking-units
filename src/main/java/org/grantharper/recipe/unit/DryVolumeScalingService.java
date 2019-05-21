package org.grantharper.recipe.unit;

import javax.measure.Quantity;
import javax.measure.quantity.Volume;

import static org.grantharper.recipe.unit.CookingUnits.*;

public class DryVolumeScalingService extends ScalingServiceAbstract<Volume> {

    Quantity<Volume> convertToAppropriateUnit(Quantity<Volume> input) {

        if (input.getUnit().equals(CUP)) {
            System.out.println("Cup amount found");
            return convertCupsToAppropriateUnit(input);
        }
        if (input.getUnit().equals(TEASPOON)) {
            System.out.println("Teaspoon amount found");
            return convertTeaspoonsToAppropriateUnit(input);
        }
        if (input.getUnit().equals(TABLESPOON)) {
            System.out.println("Tablespoon amount found");
            return convertTablespoonsToAppropriateUnit(input);
        }
        return input;
    }

    private Quantity<Volume> convertCupsToAppropriateUnit(Quantity<Volume> input) {
        if (input.getValue().doubleValue() <= 0.0625) {
            return input.to(TEASPOON);
        } else if (input.getValue().doubleValue() <= 0.25) {
            return input.to(TABLESPOON);
        }
        return input;
    }

    private Quantity<Volume> convertTeaspoonsToAppropriateUnit(Quantity<Volume> input) {
        if (input.getValue().doubleValue() >= 12.0) {
            return input.to(CUP);
        } else if (input.getValue().doubleValue() >= 6.0) {
            return input.to(TABLESPOON);
        }
        return input;
    }

    private Quantity<Volume> convertTablespoonsToAppropriateUnit(Quantity<Volume> input) {
        if (input.getValue().doubleValue() < 1.0) {
            return input.to(TEASPOON);
        } else if (input.getValue().doubleValue() >= 4.0) {
            return input.to(CUP);
        }
        return input;
    }

}
