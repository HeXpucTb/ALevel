import examples.ExampleOfClassCastException;
import examples.ExampleOfNullPointerException;
import examples.ExampleOfArrayIndexOutOfBoundsException;
import examples.ExampleOfNumberFormatException;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Пример NumberFormatException");
        ExampleOfNumberFormatException example1 = new ExampleOfNumberFormatException();
        String[] array = example1.callNumFormatEx();

        System.out.println("Пример NullPointerException");
        ExampleOfNullPointerException example2 = new ExampleOfNullPointerException();
        example2.callNullPointerEx(array);

        System.out.println("Пример ArrayIndexOutOfBoundsException");
        ExampleOfArrayIndexOutOfBoundsException example = new ExampleOfArrayIndexOutOfBoundsException();
        example.callArInOutOBoundsEx(array);

        System.out.println("Пример ClassCastException");
        ExampleOfClassCastException example3 = new ExampleOfClassCastException();
        example3.callClassCastEx();

    }
}
