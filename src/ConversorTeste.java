import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConversorTest {
    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, Conversor.fahrenheitToCelsius(32), 0.001);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(212.0, Conversor.celsiusToFahrenheit(100), 0.001);
    }
}
