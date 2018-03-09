package examples;


public class ExampleOfArrayIndexOutOfBoundsException extends Example {
    public void callArInOutOBoundsEx(String[] array){
        if(array.length==30) {
            for (int i = 0; i < 30; i++) {
                System.out.print(" " + array[i]);
            }
            System.out.println("");
        }
        else {
            for (String i:array) {
                System.out.println(" "+i);
            }
            System.out.println("");
        }
    }
}
