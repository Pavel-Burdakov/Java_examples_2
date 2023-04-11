package Lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class removeIF {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("First");
        arrayList.add("Head");
        arrayList.add("learning Java");
        arrayList.add("learning lamddas");

        arrayList.removeIf(element->element.length()>5);
        System.out.println(arrayList);

        Predicate<String> P1 =  element -> element.length()==4;
        arrayList.removeIf(P1);
        System.out.println(arrayList);



    }

}
