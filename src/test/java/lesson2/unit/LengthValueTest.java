package lesson2.unit;

import lesson2.LengthValue;
import org.junit.Test;

import static lesson2.LengthUnit.*;
import static org.junit.Assert.assertTrue;

public class LengthValueTest {

    @Test
    public void shouldReturnStringWithUnit() {
        LengthValue value = new LengthValue(mm, 1200D);
        assertTrue(value.toString().equals("1200.0" + mm));
    }

    @Test
    public void shouldReturnStringWithSpecifiedUnit() {
        LengthValue value = new LengthValue(mm, 1200D);
        assertTrue(value.toString(cm).equals("120.0" + cm));
        assertTrue(value.toString(m).equals("1.2" + m));
    }

    @Test
    public void shouldAddTwoValues() {
        LengthValue value1 = new LengthValue(mm, 1200D);
        LengthValue value2 = new LengthValue(mm, 1200D);
        assertTrue(value1.add(value2).getValue() == 2400D);
    }

    @Test
    public void shouldSubTwoValues() {
        LengthValue value1 = new LengthValue(mm, 1200D);
        LengthValue value2 = new LengthValue(m, 1.1D);
        assertTrue(value1.sub(value2).getValue() == 100D);
    }

    @Test
    public void shouldMultiplyValue() {
        LengthValue value1 = new LengthValue(mm, 1200D);
        assertTrue(value1.multiply(3).getValue() == 3600D);
    }

    @Test
    public void shouldDivideValue() {
        LengthValue value1 = new LengthValue(mm, 1200D);
        assertTrue(value1.divide(5).getValue() == 240D);
    }

    @Test
    public void shouldEqual() {
        LengthValue value1 = new LengthValue(cm, 120D);
        LengthValue value2 = new LengthValue(mm, 1200D);
        assertTrue(value1.equals(value2));
    }
}