package examples;


public class ExampleOfArrayIndexOutOfBoundsException extends Example {
    public void callArInOutOBoundsEx(String[] array){
        try{
            for (int i = 0; i < 30; i++) {
                System.out.print(" "+array[i]);
            }
            System.out.println("");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вышли за пределы массива");
        }
    }
}
