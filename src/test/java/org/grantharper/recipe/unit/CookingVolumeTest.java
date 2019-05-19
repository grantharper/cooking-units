package org.grantharper.recipe.unit;


import org.junit.Test;
import tec.units.ri.function.RationalConverter;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.TransformedUnit;
import tec.units.ri.unit.Units;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Volume;

import static org.assertj.core.api.Assertions.assertThat;
import static tec.units.ri.unit.MetricPrefix.MILLI;
import static tec.units.ri.unit.Units.LITRE;

public class CookingVolumeTest {

    @Test
    public void exploreTeaspoonAndTablespoon() {

        Unit<Volume> TEASPOON = new TransformedUnit<>("tsp", LITRE,
                new RationalConverter(202.884, 1));

        Unit<Volume> TABLESPOON = TEASPOON.multiply(3);

        Quantity<Volume> sugar = Quantities.getQuantity(3, TEASPOON);

        assertThat(sugar.getUnit()).isEqualTo(TEASPOON);
        assertThat(sugar.getValue()).isEqualTo(3);

        Quantity<Volume> added = sugar.add(Quantities.getQuantity(3, TEASPOON));

        assertThat(added.getValue()).isEqualTo(6);
        assertThat(added.getUnit()).isEqualTo(TEASPOON);

        assertThat(added.to(TABLESPOON).getUnit()).isEqualTo(TABLESPOON);
        assertThat(added.to(TABLESPOON).getValue()).isEqualTo(2.0);

    }


}
