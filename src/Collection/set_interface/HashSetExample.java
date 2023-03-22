package Collection.set_interface;

import java.util.HashSet;
import java.util.Set;


/*
* set - множество/коллекция уникальных элементов
* в основе лежит hashMap, поэтому это быстрая структура данных
* у данного hashMap - ключи это элементы hashSet,
* а значения - заглушка константа
* не запоминает порядок добавления элементов
* не может содержать дубликаты
* может содержать  null
 */

public class HashSetExample {

    public static void main(String[] args) {

        Set<String>set = new HashSet<>();
        // внутренне вызывается метод put от hasMap
        set.add("Harry");
        set.add("Marty");
        set.add("Dart");
        set.add("Zaur");
        set.add("Igor");
        set.add(null);

        System.out.println(set);
        System.out.println("----------------");

        for (String s:set){
            System.out.println(s);
        }

        set.remove("Zaur");
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains("Igor"));

        System.out.println("----------------");
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        // объединение множеств
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union);
        System.out.println("----------------");

        // пересечение множеств
        Set<Integer> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        System.out.println(intersect);
        System.out.println("----------------");

        // разность множеств
        Set<Integer> subtract = new HashSet<>(set1);
        subtract.removeAll(set2);
        System.out.println(subtract);





    }

}
