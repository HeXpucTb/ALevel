import examples.*;

public class Demo {
    public static void main(String[] args) {
        //Все перечисленные ниже исключения unchecked, их можно не обрабатывать
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
        Example example4 = example3.callClassCastEx();
        System.out.println(example4.toString());
    }
}
