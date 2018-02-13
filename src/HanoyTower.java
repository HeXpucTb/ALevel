import java.util.Scanner;

public class HanoyTower {
    private static int steps = 1;
    Scanner in = new Scanner(System.in);

    public void callHanoyTower(){
        System.out.println("Условие задачи:");
        System.out.println("Ханойские башни: переместить n дисков");
        System.out.println("со стержня 1 на стержень 3, используя");
        System.out.println("промежуточный стержень 2 и соблюдая законы Брамы:");
        System.out.println("1)диски можно перемещать с одного стержня на другой только по одному;");
        System.out.println("2) нельзя класть больший диск на меньший;");
        System.out.println();
        System.out.println("Введите число дисков: ");
        int n = in.nextInt();
        long s = hanoyTower(n,"1 стерж","2 стерж","3 стерж");
        System.out.println("Кол-во шагов = "+ s);
        System.out.println();
    }

    private int hanoyTower(int n, String source, String temp, String destin){
        if(n==1){
            System.out.println("Переместили из "+ source  + "ня на "+ destin + "ень "+n+"й диск");
        }
        else{
            hanoyTower(n-1,source,destin,temp);
            System.out.println("Переместили из "+source+"ня на "+destin+"ень "+n+"й диск");
            hanoyTower(n-1,temp,source,destin);
        }
        return steps++;
    }
}
