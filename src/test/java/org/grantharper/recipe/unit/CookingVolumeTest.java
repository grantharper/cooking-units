package org.grantharper.recipe.unit;


import org.junit.Test;
import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Volume;

import static org.assertj.core.api.Assertions.assertThat;
import static org.grantharper.recipe.unit.CookingUnits.*;

public class CookingVolumeTest {

    @Test
    public void exploreTeaspoonAndTablespoon() {


        Quantity<Volume> sugar = Quantities.getQuantity(3, TEASPOON);

        assertThat(sugar.getUnit()).isEqualTo(TEASPOON);
        assertThat(sugar.getValue()).isEqualTo(3);

        Quantity<Volume> added = sugar.add(Quantities.getQuantity(3, TEASPOON));

        assertThat(added.getValue()).isEqualTo(6);
        assertThat(added.getUnit()).isEqualTo(TEASPOON);

        assertThat(added.to(TABLESPOON).getUnit()).isEqualTo(TABLESPOON);
        assertThat(added.to(TABLESPOON).getValue()).isEqualTo(2.0);

    }

    @Test
    public void testTablespoonsToTeaspoons() {

        Quantity<Volume> quantity = Quantities.getQuantity(3, TABLESPOON);

        Quantity<Volume> tsp = quantity.to(TEASPOON);

        assertThat(tsp.getUnit()).isEqualTo(TEASPOON);
        assertThat(tsp.getValue()).isEqualTo(9.0);

    }


    @Test
    public void exploreFractionTeaspoon() {
        Quantity<Volume> fraction = Quantities.getQuantity(0.25, TEASPOON);

        Quantity<Volume> divided = fraction.divide(2);

        assertThat(divided.getValue()).isEqualTo(0.125);
    }


    @Test
    public void testCupsToTablespoons() {

        Quantity<Volume> flour = Quantities.getQuantity(1, CUP);

        Quantity<Volume> divided = flour.divide(4);

        Quantity<Volume> tbsp = divided.to(TABLESPOON);

        assertThat(tbsp.getUnit()).isEqualTo(TABLESPOON);
        assertThat(tbsp.getValue()).isEqualTo(4.0);
    }







}
