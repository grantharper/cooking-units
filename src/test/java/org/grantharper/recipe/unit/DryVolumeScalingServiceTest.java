package org.grantharper.recipe.unit;

import org.junit.Before;
import org.junit.Test;
import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Volume;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.grantharper.recipe.unit.CookingUnits.*;

public class DryVolumeScalingServiceTest {

    private DryVolumeScalingService dryVolumeScalingService;

    @Before
    public void setup() {
        this.dryVolumeScalingService = new DryVolumeScalingService();
    }

    @Test
    public void scaleListOfQuantities() {
        var original = List.of(Quantities.getQuantity(2, CUP), Quantities.getQuantity(1, TABLESPOON),
                Quantities.getQuantity(1, TEASPOON), Quantities.getQuantity(0.25, CUP));

        var scaled = original.stream().map(volumeQuantity -> dryVolumeScalingService.scale(volumeQuantity, 0.5))
                              .collect(Collectors.toList());

        assertThat(scaled.get(0).getValue()).isEqualTo(1.0);
        assertThat(scaled.get(0).getUnit()).isEqualTo(CUP);
        assertThat(scaled.get(1).getValue()).isEqualTo(1.5);
        assertThat(scaled.get(1).getUnit()).isEqualTo(TEASPOON);
        assertThat(scaled.get(2).getValue()).isEqualTo(0.5);
        assertThat(scaled.get(2).getUnit()).isEqualTo(TEASPOON);
        assertThat(scaled.get(3).getValue()).isEqualTo(2.0);
        assertThat(scaled.get(3).getUnit()).isEqualTo(TABLESPOON);

    }

    @Test
    public void scaleTablespoonsToTeaspoons() {

        var oil = Quantities.getQuantity(1, TABLESPOON);
        var oilInHalf = dryVolumeScalingService.scale(oil, 0.5);

        assertThat(oilInHalf.getUnit()).isEqualTo(TEASPOON);
        assertThat(oilInHalf.getValue()).isEqualTo(1.5);

    }

    @Test
    public void shouldConvertFromTablespoonToTeaspoon() {
        var halfTablespoon = Quantities.getQuantity(0.5, TABLESPOON);

        Quantity<Volume> converted = dryVolumeScalingService.convertToAppropriateUnit(halfTablespoon);

        assertThat(converted.getUnit()).isEqualTo(TEASPOON);
        assertThat(converted.getValue()).isEqualTo(1.5);
    }

    @Test
    public void shouldConvertFromTeaspoonToTablespoon() {
        var sixTeaspoons = Quantities.getQuantity(6, TEASPOON);
        var converted = dryVolumeScalingService.convertToAppropriateUnit(sixTeaspoons);

        assertThat(converted.getUnit()).isEqualTo(TABLESPOON);
        assertThat(converted.getValue()).isEqualTo(2.0);
    }

    @Test
    public void shouldConvertFromTablespoonsToCups() {
        var fourTablespoons = Quantities.getQuantity(4, TABLESPOON);
        var converted = dryVolumeScalingService.convertToAppropriateUnit(fourTablespoons);

        assertThat(converted.getUnit()).isEqualTo(CUP);
        assertThat(converted.getValue()).isEqualTo(0.25);
    }

    @Test
    public void shouldConvertFromTeaspoonsToCups() {
        var twelveTeaspoons = Quantities.getQuantity(12, TEASPOON);
        var converted = dryVolumeScalingService.convertToAppropriateUnit(twelveTeaspoons);

        assertThat(converted.getUnit()).isEqualTo(CUP);
        assertThat(converted.getValue()).isEqualTo(0.25);
    }

    @Test
    public void shouldConvertCupsToTablespoons() {
        var oneEighthCup = Quantities.getQuantity(0.125, CUP);
        var converted = dryVolumeScalingService.convertToAppropriateUnit(oneEighthCup);

        assertThat(converted.getUnit()).isEqualTo(TABLESPOON);
        assertThat(converted.getValue()).isEqualTo(2.0);
    }

    @Test
    public void shouldConvertCupsToTeaspoons() {
        var oneThirtySecondCup = Quantities.getQuantity(1.0 / 32.0, CUP);
        var converted = dryVolumeScalingService.convertToAppropriateUnit(oneThirtySecondCup);

        assertThat(converted.getUnit()).isEqualTo(TEASPOON);
        assertThat(converted.getValue()).isEqualTo(1.5);
    }
}