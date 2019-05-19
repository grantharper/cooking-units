package org.grantharper.recipe.unit;

import org.junit.Test;
import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Volume;

import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void testScalePizzaDoughRecipe() {
        Quantity<Volume> wheatFlour = Quantities.getQuantity(1, CUP);
        Quantity<Volume> allPurposeFlour = Quantities.getQuantity(2, CUP);
        Quantity<Volume> salt = Quantities.getQuantity(0.5, TEASPOON);
        Quantity<Volume> oliveOil = Quantities.getQuantity(0.25, CUP);
        Quantity<Volume> sugar = Quantities.getQuantity(1, TEASPOON);
        Quantity<Volume> activeDryYeast = Quantities.getQuantity(1, TABLESPOON);
        Quantity<Volume> water = Quantities.getQuantity(1, CUP);

        List<Quantity<Volume>> ingredients = List.of(wheatFlour, allPurposeFlour, salt, oliveOil, sugar, activeDryYeast, water);

        List<Quantity<Volume>> scaledIngredients = ingredients.stream().map(volumeQuantity -> volumeQuantity.divide(2)).collect(Collectors.toList());

        assertThat(scaledIngredients.get(0).getValue()).isEqualTo(0.5);
        assertThat(scaledIngredients.get(1).getValue()).isEqualTo(1.0);
        assertThat(scaledIngredients.get(2).getValue()).isEqualTo(0.25);
        assertThat(scaledIngredients.get(3).getValue()).isEqualTo(0.125);
        assertThat(scaledIngredients.get(4).getValue()).isEqualTo(0.5);
        assertThat(scaledIngredients.get(5).getValue()).isEqualTo(0.5);
        assertThat(scaledIngredients.get(6).getValue()).isEqualTo(0.5);

    }





}
