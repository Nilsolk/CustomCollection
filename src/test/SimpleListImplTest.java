package test;

import org.junit.Test;
import service.SimpleList;
import service.imlpementation.SimpleListImpl;
import utils.GenComparator;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleListImplTest {
    private final SimpleList<String> listString = new SimpleListImpl<>();

    @Test
    public void add() {
        listString.add("First");
        listString.add("Second");

        String expected = "[First, Second]";
        String actual = listString.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void insert() throws Exception {
        listString.add("First");
        listString.add("Second");
        listString.insert(0, "NewFirst");

        String expected = "[NewFirst, Second]";
        String actual = listString.toString();
        assertEquals(expected, actual);

    }

    @Test(expected = Exception.class)
    public void small_index_insert() throws Exception {
        listString.add("First");
        listString.add("Second");
        listString.insert(-1, "NewFirst");
    }

    @Test(expected = Exception.class)
    public void big_index_insert() throws Exception {
        listString.add("First");
        listString.add("Second");
        listString.insert(10, "NewFirst");
    }

    @Test
    public void remove() throws Exception {
        listString.add("First");
        listString.add("Second");
        listString.remove(0);

        String expected = "[Second]";
        String actual = listString.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void small_index_remove() throws Exception {
        listString.add("First");
        listString.add("Second");
        listString.remove(-1);
    }

    @Test(expected = Exception.class)
    public void big_index_remove() throws Exception {
        listString.add("First");
        listString.add("Second");
        listString.remove(10);
    }

    @Test(expected = NullPointerException.class)
    public void empty_element_at_index_remove() throws Exception {
        listString.add("First");
        listString.add("Second");
        listString.remove(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void small_index_get() {
        listString.add("First");
        listString.add("Second");
        listString.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void big_index_get() {
        listString.add("First");
        listString.add("Second");
        listString.get(11);
    }

    @Test
    public void no_element_get() {
        listString.add("First");
        listString.add("Second");
        Object actual = listString.get(3);
        int excepted = -1;

        assertEquals(excepted, actual);
    }

    @Test
    public void get() {
        listString.add("First");
        listString.add("Second");
        Object actual = listString.get(0);
        String excepted = "First";

        assertEquals(excepted, actual);

    }

    @Test
    public void size() {
        listString.add("First");
        listString.add("Second");
        int actual = listString.size();
        int excepted = 2;

        assertEquals(excepted, actual);
    }

    @Test
    public void addAll() {
        SimpleList<String> secondStringList = new SimpleListImpl<>();
        secondStringList.add("First");
        secondStringList.add("Second");
        listString.add("Third");
        listString.add("Fourth");

        listString.addAll(secondStringList);

        String actual = listString.toString();
        String expected = "[Third, Fourth, First, Second]";

        assertEquals(expected, actual);
    }

    @Test
    public void first() {
        listString.add("First");
        listString.add("Second");
        listString.add("First");
        listString.add("Second");
        int actual = listString.first("Second");
        int excepted = 1;

        assertEquals(excepted, actual);
    }

    @Test
    public void last() {
        listString.add("First");
        listString.add("Second");
        listString.add("First");
        listString.add("Second");
        int actual = listString.last("Second");
        int excepted = 3;

        assertEquals(excepted, actual);
    }

    @Test
    public void contains() {
        listString.add("First");
        listString.add("Second");
        boolean actual = listString.contains("Second");
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void isEmpty() {
        boolean actual = listString.isEmpty();
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void sort() {
        listString.add("A");
        listString.add("D");
        listString.add("C");
        listString.add("B");
        listString.add("E");

        String actual = listString.sort(new GenComparator<>()).toString();
        String excepted = "[A, B, C, D, E]";

        assertEquals(excepted, actual);
    }

    @Test
    public void shuffle() throws Exception {
        listString.add("A");
        listString.add("D");
        listString.add("C");
        listString.add("B");
        listString.add("E");

        SimpleList<String> shuffledList = listString.shuffle();
        long condition = IntStream.range(0, shuffledList.size())
                .filter(it -> shuffledList.get(it) != listString.get(it)
                        && shuffledList.contains((String) listString.get(it)))
                .count();

        assertTrue(condition > 0);

    }
}