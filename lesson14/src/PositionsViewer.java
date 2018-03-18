import com.shop.position.Position;
import com.shop.position.impl.Apple;
import com.shop.position.impl.Pen;
import position.Apples;
import position.impl.Pens;

import java.util.*;

public class PositionsViewer {
    private static List<Position> positions = new ArrayList<>();
    private static final Random random = new Random();
    public static void main(String[] args) {
        initPositions();
        PositionWrapper wrapper = new PositionWrapper(positions);
        for (Position pos:wrapper) {
            System.out.println("Name: "+pos.getName()+" price: "+pos.getPrice());
        }
    }
    private static void initPositions(){
        Random random = new Random();
        for (int i = 0; i < random.nextInt(30); i++) {
            positions.add(new Apple(random.nextInt(3)+1, getRandomApple().name()));
            positions.add(new Pen(random.nextInt(3)+1,getRandomPen().name()));
        }
    }
    private static Apples getRandomApple(){
        int choise = random.nextInt(Apples.values().length);
        return Apples.values()[choise];
    }
    private static Pens getRandomPen(){
        int choise = random.nextInt(Pens.values().length);
        return Pens.values()[choise];
    }
}
