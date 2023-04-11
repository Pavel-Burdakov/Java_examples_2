package Lambda;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {

    public static void main(String[] args) {

        List<String> stringList = List.of("Head", "First", "Good", "Bingo", "Strike");

        stringList.forEach(element-> System.out.println(element));

        List<Integer> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(4);
        integerArrayList.add(5);

        integerArrayList.forEach(element->
        {
            System.out.println(element);
            element *= element;
            System.out.println(element);
        });


    }

}
