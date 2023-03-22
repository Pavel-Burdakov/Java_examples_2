package Collection.map_interface;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;


/*
* LinkedHashMap является наследником HashMap.
* Хранит информацию о порядке добавления элементов
* или порядке их использования.
* Производительность методов несколько ниже чем у HashMap
*
* помимо самих ключа и значения хранятся ссылки на
* предыдущий элемент и следующий

 */


public class LinkedHashMapExample {

    public static void main(String[] args) {


        Students st1 = new Students("Zaur", "Tregulov", 5);
        Students st2 = new Students("Ivan", "Ivanov", 1);
        Students st3 = new Students("Mark", "Tven", 3);
        Students st4 = new Students("Marti", "Mcfly", 4);



        // accessOrder показывает как мы хотим сохранять элементы
        // в порядке добавления false default или
        // в порядке использования true
        LinkedHashMap<Double, Students> linkedHashMap =
                new LinkedHashMap<>(16, 0.75f, true);


        linkedHashMap.put(5.8, st1);
        linkedHashMap.put(5.1, st2);
        linkedHashMap.put(8.2, st3);
        linkedHashMap.put(7.4, st4);

        // в каком порядке добавили в таком порядке и хранятся элементы
        // сортировке нет
        System.out.println(linkedHashMap);

        System.out.println("--------------------------------");
        System.out.println(linkedHashMap.get(5.1));
        System.out.println(linkedHashMap.get(5.8));
        System.out.println("--------------------------------");
        // последним ставится элемент который мы последний использовали
        System.out.println(linkedHashMap);




    }


}
