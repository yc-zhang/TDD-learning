package lesson2.model;

import org.junit.Test;

import static lesson2.model.LengthUnit.CM;
import static lesson2.model.LengthUnit.M;
import static lesson2.model.LengthUnit.MM;
import static org.junit.Assert.assertTrue;

public class LengthValueTest {

    @Test
    public void shouldReturnStringWithUnit() {
        LengthValue value = new LengthValue(MM, 1200D);
        assertTrue(value.toString().equals("1200.0MM"));
    }

    @Test
    public void shouldReturnStringWithSpecifiedUnit() {
        LengthValue value = new LengthValue(MM, 1200D);
        assertTrue(value.toString(CM).equals("120.0CM"));
        assertTrue(value.toString(M).equals("1.2M"));
    }
}