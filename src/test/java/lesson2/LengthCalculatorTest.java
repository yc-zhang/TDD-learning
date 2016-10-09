package lesson2;

import lesson2.model.LengthValue;
import org.junit.Test;

import static lesson2.LengthCalculator.*;
import static lesson2.model.LengthUnit.*;
import static org.junit.Assert.assertTrue;

public class LengthCalculatorTest {

    @Test
    public void shouldAddTwoValues() throws Exception {
        LengthValue value1 = new LengthValue(CM, 100D);
        LengthValue value2 = new LengthValue(M, 1D);
        assertTrue(lengthAdd(value1, value2).getValue() == 2000D);
    }

    @Test
    public void shouldSubTwoValues() throws Exception {
        LengthValue value1 = new LengthValue(MM, 2100D);
        LengthValue value2 = new LengthValue(M, 1.2D);
        assertTrue(lengthSub(value1, value2).getValue() == 900D);
    }

    @Test
    public void shouldMultiplyLengthValue() throws Exception {
        LengthValue value1 = new LengthValue(MM, 2100D);
        assertTrue(lengthMultiply(value1, 2).getValue() == 4200D);
    }

    @Test
    public void shouldDivideLengthValue() throws Exception {
        LengthValue value1 = new LengthValue(MM, 2100D);
        assertTrue(lengthDivide(value1, 3).getValue() == 700D);
    }
}