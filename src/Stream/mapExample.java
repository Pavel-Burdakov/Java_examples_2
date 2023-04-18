package Stream;

import java.util.*;
import java.util.stream.Collectors;


/*
Stream - последовательность элементов, поддерживающих последовательные
и параллельные операции над ними (коллекции / массивы)
к ним полезно применять лямбда выражения
 */


public class mapExample {


    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("First");
        stringList.add("Head");
        stringList.add("Learning");
        stringList.add("New");
        stringList.add("ok");

     /*   System.out.println(stringList);
        System.out.println("-----------------------");

        // заменим значения на их длину
        // вот так делали бы если бы не было потоков
        for (int i = 0; i<stringList.size(); i++){
            stringList.set(i, String.valueOf(stringList.get(i).length()));
        }
        System.out.println(stringList);
        System.out.println("-----------------------");*/

        /*методы работают не напрямую с коллекциями, перед тем как работать
        мы преобразовываем эти коллекции в потоки
        */

        // создаем поток из листа в котором элементы нашего листа
        // метод map берет поочереди каждый элемент из stream и
        // сопоставляет ему элемент который получается из него
        // после выполнения тех действий,
        // которые описаны внутри map с помощью лямбда выражении

        // на выходе map получаем stream с длиной элементов,
        // присвоить его просто так новому листу нельзя
        // нам нужен метод collect который преобразует поток в list
        // таким образом все методы stream, в том числе map не меняют коллекцию
        // на которой они были вызваны
        List<Integer> integerList = stringList.stream().map(element->element.length())
                .collect(Collectors.toList());
        System.out.println(integerList);
        System.out.println("-----------------------");

        // пример для массива
        // map в своем параметре использует интерфейс function, поэтому должно быть return
        int[] array = {5,6,3,8,1};
        System.out.println(Arrays.toString(array));
        array = Arrays.stream(array).map(element->
        {
            if (element%3==0)
                element = element/3;
            return element;
        }).toArray();
        System.out.println(Arrays.toString(array));
        System.out.println("-----------------------");


        //пример для set
        Set<String> stringSet = new TreeSet<>();
        stringSet.add("First");
        stringSet.add("Head");
        stringSet.add("Learning");
        stringSet.add("New");
        stringSet.add("ok");

        Set<Integer> integerSet =  stringSet.stream().map(element->element.length()).collect(Collectors.toSet());
        System.out.println(integerSet); System.out.println("-----------------------");
        // полученный поток можно преобразовать и в set и в List
        List<Integer> integerList2 =  stringSet.stream().map(element->element.length()).collect(Collectors.toList());
        System.out.println(integerList2); System.out.println("-----------------------");




    }


}
