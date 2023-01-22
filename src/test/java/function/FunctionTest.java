package function;

import main.Main;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    public final static double EPS = 1e-9;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({"0.0, 4.0", "1.4, 3.6490364819799543", "2.0, 0.9391485505499116"})
    void testFunctionParam(double x, double expectedFunction1) {
        assertThat(Main.Function.function( x))
                .isCloseTo(expectedFunction1, Percentage.withPercentage(0.001));

    }
    @ParameterizedTest
    @CsvSource({"0.002,1001"})
    void testStepsParam(double step, double expectedStepQty) {
        int actual = Main.Function.steps(step);
        assertEquals(expectedStepQty,actual,EPS);
    }

    @ParameterizedTest
    @CsvSource({"0, 4.0", "700, 3.649", "1000, 0.93914"})
    void testDefineElementsParam(int i, double expectedY) {
        assertThat(Main.Function.defineElements(Main.Function.createArray(),i))
                .isCloseTo(expectedY, Percentage.withPercentage(0.001));
    }
    @Test
    void testMinIndexElementInArrayParam() {
        int actual = Main.Function.minIndexElementInArray(Main.Function.createArray());
//        int expectedMinIndexOfElement = 1000;
        int expectedMinIndexOfElement = expectedMinIndexElement(Main.Function.createArray());

    assertThat(Main.Function.minIndexElementInArray(Main.Function.createArray()))
            .isCloseTo(expectedMinIndexOfElement,Percentage.withPercentage(0.0001));
    }

    public static int expectedMinIndexElement(double[]array){
        double min = array[0];
        int minIndex = 0;
        for (int i=0; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
                {
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    @Test
    void testMaxIndexElementInArrayParam() {
//        int expectedMaxIndexOfElement = 699;
        int expectedMaxIndexOfElement = expectedMaxIndexElement(Main.Function.createArray());

        assertThat(Main.Function.maxIndexElementInArray(Main.Function.createArray()))
                .isCloseTo(expectedMaxIndexOfElement,Percentage.withPercentage(0.0001));
    }

    public static int expectedMaxIndexElement(double[]array){
        double max = array[0];
        int maxIndex = 0;
        for (int i=0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
                {
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }

    @Test
    void testSumElementInArrayParam() {
//        double expectedSumOfElement = 4224.112;
        double expectedSumOfElement = expectedSumElementInArray(Main.Function.createArray());
        assertThat(Main.Function.sumElementInArray(Main.Function.createArray()))
                .isCloseTo(expectedSumOfElement, Percentage.withPercentage(0.0001));
    }

    public static double expectedSumElementInArray(double[]array){
        double sum = 0;
        for (int i=0; i < array.length; i++){
            sum+=array[i];
        }
        return sum;
    }

    @Test
    void testAverageElementInArrayParam() {
//        double expectedAverageOfElement = 4.219;
        double expectedAverageOfElement = expectedAverageElementInArray(Main.Function.createArray());

        assertThat(Main.Function.averageElementInArray(Main.Function.createArray()))
                .isCloseTo(expectedAverageOfElement,Percentage.withPercentage(0.03));;
    }
    public static double expectedAverageElementInArray(double[]array){
        double sum = 0;
        for (int i=0; i < array.length; i++){
            sum+=array[i];
        }
        return sum/array.length;
    }

}