package org.grantharper.recipe.unit;

import tec.units.ri.function.MultiplyConverter;
import tec.units.ri.function.RationalConverter;
import tec.units.ri.unit.TransformedUnit;

import javax.measure.Unit;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

import static tec.units.ri.unit.Units.GRAM;
import static tec.units.ri.unit.Units.LITRE;

public class CookingUnits {


    public static final Unit<Volume> TEASPOON = new TransformedUnit<>("tsp", LITRE,
            new MultiplyConverter(202.884136));

    public static final Unit<Volume> TABLESPOON = new TransformedUnit<>("Tbsp", TEASPOON,
            new MultiplyConverter(3));


    public static final Unit<Volume> CUP = new TransformedUnit<>("cup", TABLESPOON,
            new MultiplyConverter(16));

    public static final Unit<Volume> FLUID_OUNCE = new TransformedUnit<>(null, TABLESPOON,
            new MultiplyConverter(2));

    public static final Unit<Mass> OUNCE = new TransformedUnit<>(null, GRAM,
            new MultiplyConverter(28.34952313));

    public static final Unit<Mass> POUND = new TransformedUnit<>(null, OUNCE,
            new MultiplyConverter(16));


}
