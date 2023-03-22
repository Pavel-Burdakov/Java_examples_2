package Collection.list_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample2 {

    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");
        StringBuilder sb5 = new StringBuilder("E");

        StringBuilder[] SBarray = {sb1, sb2, sb3, sb4, sb5};

        // преобразует array в List
        List <StringBuilder> list = Arrays.asList(SBarray);
        System.out.println(list);

        // только list в таком варианте полностью связан с массивом

        SBarray[0].append("!!!");
        SBarray[1] = new StringBuilder("S");
        System.out.println(list);


        ArrayList<String> AL2 = new ArrayList<>(200);
        AL2.add("Hallo");
        AL2.add("Hallo");
        AL2.add("OOK");
        AL2.add("Good");
        AL2.add("Pen");
        AL2.add("Note");

//        ArrayList<String> AL3 = new ArrayList<>(200);
//        AL2.add("Hallo");
//        AL2.add("OOK");
//
//
//        ArrayList<String> AL4 = new ArrayList<>(200);
//        AL2.add("Good");
//        AL2.add("Pen");
//
//        //удаляет из AL2 все что содержится в AL3
//        AL2.removeAll(AL3);
//
//        //оставляет в AL2 все что содержится в AL3
//        AL2.retainAll(AL4);


        // myList - это не отдельная сущность, а его представление
        // все структурные модификации нужно делать через view
        // если сделаем через array, view упадет
        List<String> myList = AL2.subList(1,3);
        System.out.println(myList);

        // размер компилятор подберет сам, можно указать 0
        String[] arr1 = AL2.toArray(new String[0]);

        // в таком варианте list неизменяемый и не может содержать null
        List<Integer> list1 = List.of(1,2,3);

        // создание неизменяемого листа из другого и не может содержать null
        List<String> list2 = List.copyOf(AL2);









    }

}
