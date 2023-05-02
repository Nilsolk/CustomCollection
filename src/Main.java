import service.SimpleList;
import service.imlpementation.SimpleListImpl;
import utils.GenComparator;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleList<String> listString = new SimpleListImpl<>();
        SimpleList<Integer> listInt = new SimpleListImpl<>();
        SimpleList<String> secondStringList = new SimpleListImpl<>();

        listInt.add(1);
        listInt.add(8);
        listInt.add(110);
        listInt.add(1);
        listInt.add(1);
        listInt.add(4);
        listInt.add(11);
        listInt.add(5);

        listString.add("A");
        listString.add("B");
        listString.add("C");
        listString.add("D");
        listString.add("E");
        listString.add("D");
        listString.add("F");

        System.out.println(listInt);
        System.out.println(listString);

        listInt.remove(1);
        listString.insert(2, "Z");

        System.out.println("Remove element " + listInt);
        System.out.println("Insert element " + listString);
        System.out.println();
        System.out.println("Get at index 2 from strings " + listString.get(2));
        System.out.println("Size of integers " + listInt.size());
        System.out.println("Last of strings " + listString.last("D"));
        System.out.println("First of integers " + listInt.first(1));
        System.out.println();
        System.out.println("Shuffled intList: " + listInt.shuffle());
        System.out.println("Shuffled stringList: " + listString.shuffle());
        System.out.println();
        System.out.println("Sorted intList: " + listInt.sort(new GenComparator<>()));
        System.out.println("Sorted stringList: " + listString.sort(new GenComparator<>()));


        System.out.println();
        System.out.println(secondStringList.isEmpty());
        System.out.println(listInt.isEmpty());
        secondStringList.add("First");
        secondStringList.add("Second");
        secondStringList.add("Third");
        secondStringList.add("First");
        secondStringList.add("Second");
        secondStringList.add("Third");
        listString.addAll(secondStringList);
        System.out.println(listString);


//
//        System.out.println("List after sort:");
//        System.out.println(listInt.sort(new GenComparator<>()));
//        System.out.println(listStringFirst.sort(new GenComparator<>()));
//
//        System.out.println(listStringFirst.first("PPP"));
//        System.out.println(listStringFirst.last("C"));
//
//        listStringSecond.add("1");
//        listStringSecond.add("2");
//        listStringSecond.add("3");
//        listStringSecond.add("4");
//        listStringSecond.add("7");
//        listStringSecond.add("8");
//        listStringSecond.add("0");
//        listStringSecond.add("2");
//
//        listStringFirst.addAll(listStringSecond);
//        System.out.println(listStringFirst);
    }
}