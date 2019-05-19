package org.grantharper.recipe.unit;

import tec.units.ri.function.RationalConverter;
import tec.units.ri.unit.TransformedUnit;

import javax.measure.Unit;
import javax.measure.quantity.Volume;

import static tec.units.ri.unit.Units.LITRE;

public class CookingUnits {


    public static final Unit<Volume> TEASPOON = new TransformedUnit<>("tsp", LITRE,
            new RationalConverter(202.884, 1));

    public static final Unit<Volume> TABLESPOON = TEASPOON.multiply(3);


}
