package lesson2;


import lesson2.model.LengthUnit;
import lesson2.model.LengthValue;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LengthUnitComparatorTest {
    @Before
    public void setUp() {
    }

    @Test
    public void sameValuesWithSameUnitShouldBeEqual() throws Exception {
        LengthValue value1 = new LengthValue(LengthUnit.CM, 100D);
        LengthValue value2 = new LengthValue(LengthUnit.CM, 100D);
        assertTrue(LengthUnitComparator.equals(value1, value2));
    }

    @Test
    public void sameValuesWithDifferentUnitShouldBeEqual() throws Exception {
        LengthValue value1 = new LengthValue(LengthUnit.CM, 100D);
        LengthValue value2 = new LengthValue(LengthUnit.M, 1D);
        assertTrue(LengthUnitComparator.equals(value1, value2));
    }

    @Test
    public void differentValuesWithSameUnitShouldNotBeEqual() throws Exception {
        LengthValue value1 = new LengthValue(LengthUnit.M, 10D);
        LengthValue value2 = new LengthValue(LengthUnit.M, 1D);
        assertFalse(LengthUnitComparator.equals(value1, value2));
    }

    @Test
    public void differentValuesWithDifferentUnitShouldNotBeEqual() throws Exception {
        LengthValue value1 = new LengthValue(LengthUnit.MM, 10D);
        LengthValue value2 = new LengthValue(LengthUnit.M, 100D);
        assertFalse(LengthUnitComparator.equals(value1, value2));
    }
}
