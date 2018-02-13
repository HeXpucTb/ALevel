public class SymmetricTime {
    public void symmetricTime(){
        String hours;
        String minutes;
        int count = 0;
        System.out.println("Условие задачи: ");
        System.out.println("Электронные часы показывают время в формате от 00:00 до 23:59. ");
        System.out.println("Подсчитать сколько раз за сутки случается так, что слева от двоеточия");
        System.out.println("показывается симметричная комбинация для той, что справа от двоеточия");
        System.out.println("(например, 02:20, 11:11 или 15:51).");
        System.out.println();
        for (int hour1 = 0; hour1<3; hour1++){
            for (int hour2 = 0; hour2 <10; hour2++){
                for (int min1 = 0; min1 < 6;min1++){
                    for (int min2 = 0; min2<10;min2++){
                        hours = String.valueOf(hour1)+String.valueOf(hour2);
                        minutes = String.valueOf(min2)+String.valueOf(min1);
                        if(hours.equals(minutes)&&Integer.parseInt(hours)<24){
                            System.out.println(""+hour1+hour2+":"+min1+min2);
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Количество совпадений: "+count);
        System.out.println();
    }
}
