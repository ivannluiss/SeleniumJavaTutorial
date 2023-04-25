package tests;

import org.example.Conversion;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class ConversionTest {
    @Test
    public void testTempConversion() throws Throwable {
        //Given
        Conversion underTest = new Conversion();
        //when
        double temperatura = 80.0d;
        String unit="F";
        double result = underTest.temCoversion(temperatura,unit);

        //Them - assertions for result of method testTempConversion(double, String)
        assertEquals(26.666666666666668,result,0.0);


    }
}
