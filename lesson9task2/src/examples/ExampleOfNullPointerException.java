package examples;

public class ExampleOfNullPointerException extends Example{
    public void callNullPointerEx(String[] array){
        try{
            for (String i:array) {
                System.out.print(" "+i);
            }
            System.out.println();
        }catch (NullPointerException e){
            System.out.println("Пустой массив");
        }
    }
}
