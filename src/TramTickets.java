public class TramTickets {
    private static int first;
    private static int second;
    private static int sum1;
    private static int sum2;
    private static int lucky = 1;
    public void luckyTikets(){
        SumOfAllNumbersN sumOfAll = new SumOfAllNumbersN();
        for (int i = 999999; i>0;i--){
            first = i/1000;
            second = i%1000;
            sum1 = sumOfAll.sumOfAllNumbers(first);
            sumOfAll.sum = 0;
            sum2 = sumOfAll.sumOfAllNumbers(second);
            if(sum1 == sum2){
                lucky++;
            }
            sumOfAll.sum = 0;
        }
        System.out.println("Всего счастливых билетов: "+ lucky);
        System.out.println();
    }

}
