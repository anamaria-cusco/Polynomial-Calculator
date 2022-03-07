import model.Operations;
import model.Polynomial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationsTest {
    private Operations operations;
    private Polynomial polynomial1;
    private Polynomial polynomial2;
    private String expectedResult;
    private String operation;


    @BeforeEach
    void setUp() {
         operations=new Operations();
         polynomial1=new Polynomial();
         polynomial2=new Polynomial();
         expectedResult="";
    }

    @AfterEach
    void tearDown() {
        System.out.println(operation +" test completed!");


    }

    @Test
    void add() {
        operation="Addition";
        try {
            polynomial1.constructMonomialsList("2x^3+2x+20");
            polynomial2.constructMonomialsList("4x^6-10x+1");
            expectedResult="+4x^6+2x^3-8x+21";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedResult,operations.add(polynomial1,polynomial2).toString(),"Addition Operation-Failed!");
    }

    @Test
    void subtract() {
        operation="Subtraction";

        try{
        polynomial1.constructMonomialsList("6x-3");
        polynomial2.constructMonomialsList("2x-1");
        expectedResult="+4x-2";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedResult,operations.subtract(polynomial1,polynomial2).toString(),"Subtraction Operation-Failed!");
    }

    @Test
    void multiply() {
        operation="Multiplication";
        try{
        polynomial1.constructMonomialsList("3x^6-4x+2");
        polynomial2.constructMonomialsList("5x-5");
        expectedResult="+15x^7-15x^6-20x^2+30x-10";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedResult,operations.multiply(polynomial1,polynomial2).toString(),"Multiplication Operation-Failed!");
    }

    @Test
    void divide() {
        operation="Division";
        try{
        polynomial1.constructMonomialsList("4x^2-4x-4");
        polynomial2.constructMonomialsList("2x-1");
        expectedResult="Q:+2,00x-1,00 --> R:-5,00";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        assertEquals(expectedResult,operations.divide(polynomial1,polynomial2),"Division Operation-Failed!");

    }

    @Test
    void integrate() {
        operation="Integration";
        try{
        polynomial1.constructMonomialsList("9x^2-14x");
        expectedResult="+3,00x^3-7,00x^2";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedResult,operations.integrate(polynomial1).displayRealCoefficients(),"Integration Operation-Failed!");
    }

    @Test
    void derive() {
        operation="Derivation";
        try{
        polynomial2.constructMonomialsList("10x^2");
        expectedResult="+20x";


        assertEquals(expectedResult,operations.derive(polynomial2).toString(),"Derivation Operation-Failed!");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
