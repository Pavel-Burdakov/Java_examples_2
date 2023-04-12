package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/*
Stream - последовательность элементов, поддерживающих последовательные
и параллельные операции над ними (коллекции / массивы)
к ним полезно применять лямбда выражения
 */


public class Test1 {


    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("First");
        stringList.add("Head");
        stringList.add("Learning");
        stringList.add("New");
        stringList.add("ok");

        System.out.println(stringList);
        System.out.println("-----------------------");

        // заменим значения на их длину
        // вот так делали бы если бы не было потоков
        for (int i = 0; i<stringList.size(); i++){
            stringList.set(i, String.valueOf(stringList.get(i).length()));
        }
        System.out.println(stringList);
        System.out.println("-----------------------");

        /*методы работают не напрямую с коллекциями, перед тем как работать
        мы преобразовываем эти коллекции в потоки
        */

        // создаем поток из листа в котором элементы нашего листа
        // метод map берет поочереди каждый элемент из stream и
        // сопоставляет ему элемент который получается из него после выполнения тех действий,
        // которые описаны внутри map с помощью в лямбда выражении

        // на выходе map получаем stream с длиной элементов,
        // присвоить его просто так новому листу нельзя
        // нам нужен метод collect который преобразует поток в list
        // таким образом все методы stream, в том числе map не меняют коллекуию
        // на которой они были вызваны
        List<Integer> integerList = stringList.stream().map(element->element.length())
                .collect(Collectors.toList());
        System.out.println(integerList);
        System.out.println("-----------------------");


    }


}
