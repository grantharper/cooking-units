//package org.grantharper.recipe.unit;
//
//import org.junit.Test;
//import tech.units.indriya.function.MultiplyConverter;
//import tech.units.indriya.quantity.Quantities;
//import tech.units.indriya.unit.Units;
//
//import javax.measure.Quantity;
//import javax.measure.quantity.Volume;
//import java.math.BigDecimal;
//
//import static javax.measure.MetricPrefix.MILLI;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class ConversionTest {
//
//    @Test
//    public void testSample() {
//        Quantity<Volume> coffee = Quantities.getQuantity(1, Units.LITRE);
//        assertThat(coffee.getUnit().getName()).isEqualTo("Litre");
//        assertThat(coffee.getValue()).isEqualTo(1);
//    }
//
//    @Test
//    public void testConversion() {
//        MultiplyConverter litresToMilliliters = MultiplyConverter.of(1000);
//        double converted = litresToMilliliters.convert(2);
//        assertThat(converted).isEqualTo(2000);
//    }
//
//    @Test
//    public void testConvertUnits() {
//        Quantity<Volume> coffee = Quantities.getQuantity(1, Units.LITRE);
//        Quantity<Volume> cream = Quantities.getQuantity(1, MILLI(Units.LITRE));
//
//        Quantity<Volume> addCoffeeToCream = cream.add(coffee);
//
//        assertThat(addCoffeeToCream.getValue()).isEqualTo(BigDecimal.valueOf(1001.0));
//        assertThat(addCoffeeToCream.getUnit()).isEqualTo(MILLI(Units.LITRE));
//
//        Quantity<Volume> addCreamToCoffee = coffee.add(cream);
//
//        assertThat(addCreamToCoffee.getValue()).isEqualTo(BigDecimal.valueOf(1.001));
//        assertThat(addCreamToCoffee.getUnit()).isEqualTo(Units.LITRE);
//    }
//
//    @Test
//    public void testConvertCustomUnits() {
//
//
//    }
//
//
//
//}
