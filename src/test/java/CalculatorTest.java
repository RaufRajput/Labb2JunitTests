import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void init(){
        calculator = new Calculator();

    }

    @AfterEach
    public void finalMessage(){
        System.out.println("im doing this because Im going to do this in real life when i work");
    }

    @Test
    @Order(1)
    public void testConstructor(){
        calculator = new Calculator(10);
        Assertions.assertEquals(10, calculator.getNumber());


    }

    @Test
    @Order(2)
    @DisplayName("Addition")
    public void testAddition(){

        Assertions.assertEquals(3, calculator.addition(5,-2));

    }

    @Test
    @Order(3)
    public void testSubtraction(){

        Assertions.assertEquals(9, calculator.subtraction(10, 1) );

    }

    @Test
    @Order(4)
    public void testMultiplication(){
        Assertions.assertEquals(15, calculator.multiplication(5,3));
    }

    @Test
    @Order(5)
    public void testDivision(){
        Assertions.assertEquals(20, calculator.division(40,2));

    }

    @Test
    public void testDivisionException(){
        Assertions.assertThrows(ArithmeticException.class, ()->
            calculator.division(10,0));

    }

    @Test
    public void testDivisionPrivate() throws Exception{
        Method method = Calculator.class.getDeclaredMethod("divisionPrivate",int.class, int.class);
        method.setAccessible(true);


    }

    @ParameterizedTest
    @ValueSource(ints = {6})
    public void menuTest(int expectedValue){
        List<String> list = calculator.calculatorMenu();
        int listSize = list.size();
        Assertions.assertEquals(expectedValue, listSize);
    }




}
