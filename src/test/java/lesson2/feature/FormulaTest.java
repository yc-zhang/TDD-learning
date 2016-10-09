package lesson2.feature;

import lesson2.LengthValue;
import org.junit.Test;

import static lesson2.LengthUnit.*;
import static org.junit.Assert.assertTrue;

public class FormulaTest {

    @Test
    public void shouldCalculateTheLengthValues() {
        LengthValue value1 = new LengthValue(m, 1);
        LengthValue value2 = new LengthValue(cm, 10);
        LengthValue value3 = new LengthValue(mm, 5);
        LengthValue result = value1.divide(4).add(value2.multiply(3)).sub(value3);
        assertTrue(result.getValue() == 545);
        assertTrue(result.toString().equals("545.0mm"));
        assertTrue(result.toString(cm).equals("54.5cm"));
    }


}
