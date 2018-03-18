import com.shop.position.Position;
import java.util.Iterator;
import java.util.List;

public class PositionWrapper  implements Iterable<Position>{
    private List<Position> positions;
    private int size;
    public PositionWrapper(List<Position> list){
        this.positions = list;
        this.size = list.size();
    }
    @Override
    public Iterator<Position> iterator() {
        return new Iterator<Position>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                ++index;
                return index<size&&positions.get(index)!=null&&positions.get(index).getPrice()<5;
            }

            @Override
            public Position next() {
                return positions.get(index);
            }
        };
    }

    public List<Position> getPositions() {
        return positions;
    }
}
