package examples;

public class ExampleOfNullPointerException extends Example{
    public void callNullPointerEx(String[] array){
        if(array.length>0){
            for (String i:array) {
                System.out.print(" "+i);
            }
            System.out.println();
        }else System.out.println("Empty array");;
    }
}
