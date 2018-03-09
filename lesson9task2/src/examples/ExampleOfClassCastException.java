package examples;

import java.util.Random;

public class ExampleOfClassCastException extends Example{
    private Example finalExample;
    public Example callClassCastEx(){
        Random random = new Random();
        Example example = new ExampleOfArrayIndexOutOfBoundsException();
            switch (random.nextInt(2)+1){
                case 1: {
                    ExampleOfNumberFormatException example1 = (ExampleOfNumberFormatException) example;
                    finalExample = example1;
                }
                case 2:{
                    ExampleOfArrayIndexOutOfBoundsException example1 = (ExampleOfArrayIndexOutOfBoundsException) example;
                    finalExample =  example1;
                }
                case 3:{
                    ExampleOfNullPointerException example1 = (ExampleOfNullPointerException) example;
                    finalExample = example1;
                }
            }
    return finalExample;
    }
}
