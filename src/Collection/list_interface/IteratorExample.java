package Collection.list_interface;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>(200);
        myList.add("Hallo");
        myList.add("Hallo");
        myList.add("OOK");
        myList.add("Good");
        myList.add("Pen");
        myList.add("Note");

        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }
}
