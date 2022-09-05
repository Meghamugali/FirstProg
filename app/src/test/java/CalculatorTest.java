import com.example.firstprog.Calculator;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    Calculator mCalculator;

    public void setUp() throws Exception {
        super.setUp();
        mCalculator = new Calculator();
    }

    public void tearDown() throws Exception {
    }

    public void testAdd()
    {
        int expected = 20;
        int actual = mCalculator.add(10,10);
        assertEquals(expected,actual);
    }
    public void testMult(){
        int expected = 20;
        int actual = mCalculator.multiply(5,4);
        assertEquals(expected,actual);
    }


}