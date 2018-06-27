package week_day;

import java.util.HashMap;
import java.util.Scanner;

public class WeekDayGetter {
    private int newYearDay;
    private int month;
    private int number;
    private HashMap<Integer,String> weekDays;

    public void run(){
        initWeekDays();
        initParameters();
        int weekDayNum = (countDaysTillDate(month,number)+newYearDay)%7;
        System.out.println(weekDays.get(weekDayNum));
    }
    private int countDaysTillDate(int month, int number){
        int daysTillTheDate=0;
        for (int i = 1; i < month; i++) {
            if (i==2){
                daysTillTheDate+=28;
                continue;
            }
            if(i==4||i==6||i==9||i==11){
                daysTillTheDate+=30;
            }
            else {
                daysTillTheDate+=31;
            }
        }
        daysTillTheDate+=number-1;
        return daysTillTheDate;
    }
    private void initWeekDays(){
        weekDays = new HashMap<>();
        weekDays.put(1,"Понедельник");
        weekDays.put(2,"Вторник");
        weekDays.put(3,"Среда");
        weekDays.put(4,"Четверг");
        weekDays.put(5,"Пятница");
        weekDays.put(6,"Суббота");
        weekDays.put(7,"Воскресенье");
    }
    private void initParameters(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter New Year week day number:");
        newYearDay = sc.nextInt();
        System.out.println("Enter month number:");
        month = sc.nextInt();
        System.out.println("Enter number:");
        number = sc.nextInt();
    }
}
