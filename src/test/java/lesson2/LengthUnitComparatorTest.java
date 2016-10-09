package lesson2;


import lesson2.model.LengthValue;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static lesson2.LengthUnitComparator.lengthEquals;
import static lesson2.model.LengthUnit.*;

public class LengthUnitComparatorTest {
    @Before
    public void setUp() {
    }

    @Test
    public void sameValuesWithSameUnitShouldBeEqual() throws Exception {
        LengthValue value1 = new LengthValue(CM, 100D);
        LengthValue value2 = new LengthValue(CM, 100D);
        assertTrue(lengthEquals(value1, value2));
    }

    @Test
    public void sameValuesWithDifferentUnitShouldBeEqual() throws Exception {
        LengthValue value1 = new LengthValue(CM, 100D);
        LengthValue value2 = new LengthValue(M, 1D);
        assertTrue(lengthEquals(value1, value2));
    }

    @Test
    public void differentValuesWithSameUnitShouldNotBeEqual() throws Exception {
        LengthValue value1 = new LengthValue(M, 10D);
        LengthValue value2 = new LengthValue(M, 1D);
        assertFalse(lengthEquals(value1, value2));
    }

    @Test
    public void differentValuesWithDifferentUnitShouldNotBeEqual() throws Exception {
        LengthValue value1 = new LengthValue(MM, 10D);
        LengthValue value2 = new LengthValue(M, 100D);
        assertFalse(lengthEquals(value1, value2));
    }
}
