import java.util.*;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Integer.parseInt;

public class RaceTrack {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Bet> bets;
    private static List<String> horsesList;
    private static List<Horse> horses = new ArrayList<>();

    public static void main(String[] args) {
        initHorses();
        makeBets();
        prepairToRace();
        joinThreads();
        double prize = getPrize();
        Bet winner = showWinner();
        if(winner!=null){
            System.out.println("Победил: "+winner.getHumanName()+"\n" +
                    "который поставил на лошадь № "+winner.getHorseNumber()+"\n" +
                    "и выиграл: "+prize);
        }else {
            System.out.println("Никто не поставил на выигравшую лошадь!");
        }
    }
    private static void initHorses(){
        boolean exit = false;
        horsesList = new ArrayList<>();
        do{
            System.out.println("Введите номер лошади:");
            int number = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите ее имя:");
            String name = scanner.nextLine();
            horsesList.add(number+" "+name);
            System.out.println("Добавить еще лошадь?(y/n)");
            if(scanner.next().equals("n")){
                exit = true;
            }
        }while (!exit);
    }
    private static void prepairToRace(){
        CyclicBarrier cb = new CyclicBarrier(horsesList.size());
        for(String horse: horsesList){
            int st = horse.indexOf(" ");
            int number = parseInt(horse.substring(0,st));
            String name = horse.substring(st);
            horses.add(new Horse(number,name, cb));
        }
    }
    private static void joinThreads(){
        for (Horse horse: horses) {
            try {
                horse.getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void makeBets(){
        boolean exit = false;
        bets = new ArrayList<>();
        do{
            scanner.nextLine();
            System.out.println("Имя человека?:");
            String name = scanner.nextLine();
            System.out.println("На какую лошадь ставите?(№)");
            int horseNum = scanner.nextInt();
            System.out.println("Ваша ставка:");
            double volume = scanner.nextDouble();
            bets.add(new Bet(name, horseNum, volume));
            System.out.println("Добавить еще одну?(y/n)");
            if (scanner.next().equals("n")){
                exit = true;
            }
        }while (!exit);
    }
    private static Bet showWinner(){
        Horse horseWinner = horses.get(0);
        Bet betWinner = null;
        long winnerFinishTime = horses.get(0).getFinishTime();
        for (Horse horse: horses) {
            if (winnerFinishTime>horse.getFinishTime()){
                winnerFinishTime = horse.getFinishTime();
            }
        }
        for (Horse horse: horses) {
            if(horse.getFinishTime()==winnerFinishTime){
                horseWinner = horse;
            }
        }
        for (Bet bet: bets) {
            if(bet.getHorseNumber() == horseWinner.getNumber()){
                betWinner = bet;
            }
        }
        return betWinner;
    }
    private static double getPrize(){
        double prize = 0;
        for (Bet bet: bets) {
            prize += bet.getVolume();
        }
        return prize/2;
    }
}
