package test;

import service.SimpleList;
import service.imlpementation.SimpleListImpl;
import utils.GenComparator;
import utils.LoggerUtils;

import java.util.Arrays;


public class Test {
    SimpleList<String> listString = new SimpleListImpl<>();
    SimpleList<Integer> listInt = new SimpleListImpl<>();
    SimpleList<String> secondStringList = new SimpleListImpl<>();
    LoggerUtils logger = new LoggerUtils();

    public void testCollection() throws Exception {

        int[] values = {1, 8, 110, 1, 1, 4, 11, 5};
        Arrays.stream(values).forEach(it -> listInt.add(it));

        String[] strings = {"A", "B", "C", "E", "D", "D", "F", "G"};
        Arrays.stream(strings).forEach(it -> listString.add(it));


        logger.log(listInt, listString, "");

        listInt.remove(1);
        listString.insert(2, "Z");

        logger.log("Remove element: " + listInt,
                "Insert element: " + listString,
                "Get at index 2 from strings: " + listString.get(2),
                "Size of integers: " + listInt.size(),
                "Last element D on index: " + listString.last("D"),
                "First element 1 on index: " + listInt.first(1),
                "Shuffled intList: " + listInt.shuffle(),
                "Shuffled stringList: " + listString.shuffle(),
                "Sorted intList: " + listInt.sort(new GenComparator<>()),
                "Sorted stringList: " + listString.sort(new GenComparator<>()),
                "NewList is empty: " + secondStringList.isEmpty(),
                "List of int is empty: " + listInt.isEmpty(),
                "");

        String[] anotherStrings = {"First", "Second", "Third", "First", "Second", "Third", "First", "Second", "Third"};
        Arrays.stream(anotherStrings).forEach(it -> secondStringList.add(it));
        listString.addAll(secondStringList);

        logger.log("Add another list to Strings " + listString,
                "New List contains First " + secondStringList.contains("First"),
                "New list contains Fifth " + secondStringList.contains("Fifth"));

    }

}
