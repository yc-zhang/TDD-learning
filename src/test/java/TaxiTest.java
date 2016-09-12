import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxiTest {

    private Taxi taxi;

    @Before
    public void setUp() {
        taxi = new Taxi();
    }

    @Test
    public void priceOf0KMShouldBe6() {
        assertEquals((Float) 6F, taxi.calculateFee(0F));
    }

    @Test
    public void priceOf1KMShouldBe6() {
        assertEquals((Float) 6F, taxi.calculateFee(1F));
    }

    @Test
    public void priceOf2KMShouldBe6() {
        assertEquals((Float) 6F, taxi.calculateFee(2F));
    }

}