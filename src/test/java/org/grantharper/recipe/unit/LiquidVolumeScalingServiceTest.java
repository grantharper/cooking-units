package org.grantharper.recipe.unit;

import org.junit.Test;
import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Volume;

import static org.assertj.core.api.Assertions.*;
import static org.grantharper.recipe.unit.CookingUnits.CUP;
import static org.grantharper.recipe.unit.CookingUnits.FLUID_OUNCE;

public class LiquidVolumeScalingServiceTest {

    private LiquidVolumeScalingService scalingService = new LiquidVolumeScalingService();

    @Test

    public void testFlOzToCups() {
        var sixteenFlOz = Quantities.getQuantity(16.0, FLUID_OUNCE);
        var converted = scalingService.convertToAppropriateUnit(sixteenFlOz);

        assertThat(converted.getUnit()).isEqualTo(CUP);
        assertThat(converted.getValue()).isEqualTo(2.0);
    }
}