import java.sql.Array;

public class MyArrayList {

    private static final int DEFAULT_SIZE = 10;
    private int size=0;
    private Object[] elements;

    public MyArrayList() {
        this.elements = new Array[DEFAULT_SIZE];
    }

    public MyArrayList(int initialSize) {
        if (initialSize > 0) {
            this.elements = new Object[initialSize];
        } else {
            throw new IllegalArgumentException("Illegal Size: "+initialSize);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public boolean add(Object o) {
        if (size == elements.length-1) resize(elements.length*2);

        elements[size++] = o;
        return true;
    }

    private void resize (int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(elements, 0, newArray,0, size);
        elements = newArray;
    }

    public void clear() {
        int to = size;
        size = 0;
        for (int i = 0 ; i < to; i++)
            elements[i] = null;
    }

    public boolean remove(int index) {
        final int newSize = size - 1;
        if (newSize > index) System.arraycopy(elements, index + 1, elements, index, newSize - index);
        elements[size = newSize] = null;
        return true;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}
