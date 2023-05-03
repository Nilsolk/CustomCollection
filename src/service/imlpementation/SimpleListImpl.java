package service.imlpementation;

import service.SimpleList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import static java.lang.System.arraycopy;

public class SimpleListImpl<T> implements SimpleList<T> {
    private final int DEFAULT = 10;
    Object[] array;


    public SimpleListImpl() {
        array = new Object[DEFAULT];
    }

    @Override
    public void add(T item) {
        int size = count();
        if (size == array.length) {
            toNewList(1);
            array[DEFAULT] = item;
        } else {
            array[size] = item;
        }
    }

    private void toNewList(int length) {
        Object[] array2 = new Object[DEFAULT * 2 + length];
        arraycopy(array, 0, array2, 0, array.length);
        array = array2;
    }

    private int count() {
        int count = 0;
        for (Object i : array) {
            if (i != null) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    @Override
    public void insert(int index, T item) throws Exception {
        if (index < 0 || index > array.length) {
            throw new Exception();
        } else array[index] = item;
    }

    @Override
    public void remove(int index) throws Exception {
        if (index < 0 || index > array.length) {
            throw new Exception();
        } else if (array[index] == null) {
            throw new NullPointerException();
        }
        Object[] tempArray = new Object[array.length - 1];
        arraycopy(array, 0, tempArray, 0, index);
        arraycopy(array, index + 1, tempArray, index, array.length - index - 1);
        array = tempArray;

    }

    @Override
    public Object get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index > array.length || array[index] == null) {
            return -1;
        } else return array[index];
    }

    @Override
    public int size() {
        return count();
    }

    @Override
    public void addAll(SimpleList<T> list) {
        if (array.length - count() < list.size()) {
            toNewList(list.size());
        }
        int count = count();
        for (int i = 0; i < list.size(); i++) {
            array[count + i] = list.get(i);
        }
    }

    @Override
    public int first(T item) {
        int count = -1;
        for (int i = 0; i < count(); i++) {
            if (array[i] == item) {
                count = i;
                break;
            }
        }
        return count;
    }

    @Override
    public int last(T item) {
        int count = -1;
        for (int i = count(); i >= 0; i--) {
            if (array[i] == item) {
                count = i;
                break;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T item) {
        boolean flag = false;
        for (Object obj : array) {
            if (obj == item) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean isEmpty() {
        return count() == 0;
    }

    @Override
    public SimpleList<T> shuffle() {
        Random random = new Random();
        Object[] temArray = array.clone();
        for (int i = 0; i < count(); i++) {
            int first = random.nextInt(0, count());
            int second = random.nextInt(0, count());
            swap(temArray, first, second);
        }

        return cast(temArray);
    }

    private void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    SimpleList<T> cast(Object[] list) {
        SimpleList<T> objects = new SimpleListImpl<>();
        for (Object obj : list) {
            objects.add((T) obj);
        }
        return objects;
    }

    @Override
    public SimpleList<T> sort(Comparator<T> comparator) {
        Object[] list = Arrays.copyOf(array, count());
        Arrays.sort(list);
        return cast(list);
    }


    @Override
    public String toString() {
        Object[] outArray = Arrays.stream(array).filter(Objects::nonNull).toArray();
        return Arrays.toString(outArray);
    }
}
