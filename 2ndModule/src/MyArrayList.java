import java.util.*;

public class MyArrayList<e> implements List<e>{
    private final int INIT_SIZE = 16;
    private e[] array;
    private int pointer = 0;

    public MyArrayList() {
        this.array = (e[]) new Object[INIT_SIZE];
    }

    public int addElement(e element){
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = element;
        return array.length -1;
    }

    @Override
    public e get(int i) {
        return array[i];
    }

    public void add(e element, int index) {
        e[] tempArr = (e[])new Object[array.length+1];
        for (int i = 0;i<index;i++){
            tempArr[i] = array[i];
        }
        tempArr[index] = element;
        for (int i = index;i<array.length;i++){
            tempArr[i+1] = array[i];
        }
        array = tempArr;
    }

    @Override
    public e remove(int index) {
        e ob = array[index];
        e[] tempArr = (e[])new Object[array.length-1];
        for (int i = 0;i<index;i++){
            tempArr[i] = array[i];
        }
        for (int i = index;i<tempArr.length;i++){
            tempArr[i] = array[i+1];
        }
        array = tempArr;
        return ob;
    }

    //Методы с ошибками

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<e> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(e e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends e> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int i, Collection<? extends e> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public e set(int i, e t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int i, e e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<e> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<e> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<e> subList(int i, int i1) {
        throw new UnsupportedOperationException();
    }

    private void resize(int newLength) {
        e[] newArray = (e[])new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
    public void printArray(){
        for (e el: array) {
            System.out.print(" " + el);
        }
    }
}
