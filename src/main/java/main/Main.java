package main;


//Вариант №3

public class Main {
    public static void main(String[] args) {
        Function.maxElement(Function.createArray());
        Function.minElement(Function.createArray());

        }
        public static class Function {

        public final static double EPS = 1e-8;
        static double step = 0.002;

            public static double function(double x) {
                double a = 2.7;
                double b = -0.3;
                double c = 4.0;

                double result = 0;
                if(x < 1.4 + EPS){result = (a * Math.pow(x, 2)) + b * x + c;}
                if(x >= 1.4 && x < 1.4 + EPS){result = (a/x +Math.sqrt(Math.pow(x,2) + 1));}
                if(x > 1.4 + EPS){result = (a + b * x)/(Math.sqrt(Math.pow(x,2) + 1));}

                return result;
            }

                public static int steps(double step){
                    int stepQty =0;
                    for (double i =0.0; i<=2.0 + EPS;i+=step){
                        stepQty++;
                    }
                    return stepQty;
                }

            public static double[] createArray() {
                double[] array = new double[steps(step)];
                double x = 0.0;
                for (int i = 0; i < steps(step); i++) {
                    array[i] = function(x);
//                    System.out.println(i+":  " + " X = " + x + " Y= " +array[i]);
                    x += step;
                }
                return array;
            }

            public static double defineElements(double[] array, int i){
                return array[i];
            }

            public static int minIndexElementInArray(double[]array){
                double min = array[0];
                int indexOfMin = 0;
                for (int i=0; i < steps(step); i++){
                    if (array[i] < min){
                        min = array[i];
                        {
                            indexOfMin = i;
                        }
                    }
                }
                return indexOfMin;
            }
            public static int maxIndexElementInArray(double[]array){
                double max = array[0];
                int indexOfMax = 0;
                for (int i=0; i < steps(step); i++){
                    if (array[i] > max){
                        max = array[i];
                        {
                            indexOfMax = i;
                        }
                    }
                }
                return indexOfMax;
            }
            public static double sumElementInArray(double[]array){
                double sum = 0;
                for (int i=0; i < steps(step); i++){
                    sum+=array[i];
                }
                return sum;
            }
            public static double averageElementInArray(double[]array){
                double sum = 0;
                for (int i=0; i < steps(step); i++){
                    sum+=array[i];
                }
                return sum/steps(step);
            }
            public static void maxElement(double[]array){
                int i = maxIndexElementInArray(array);
                System.out.println("Max element:  " + "Number: " +i + "  Y= " +array[i]);
            }
            public static void minElement(double[]array){
                int i = minIndexElementInArray(array);
                System.out.println("Min element:  " + "Number: " +i + "  Y= " +array[i]);
            }
        }
}
