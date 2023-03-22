package Collection.set_interface;


/*
Наследник HashSet.
Хранит информацию о порядке добавляемых элементов

В основе лежит HashMap.
У элементов данного HashMap ключи - это элементы LinkedHashSet
значения - это константа заглушка

не реализована возможность запоминать элементы в зависимости от последнего использования
последовательность элементов соблюдается

не содержит дубликаты

 */

import java.util.LinkedHashSet;

public class LinkedHashSetExample {

    public static void main(String[] args) {

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(4);
        linkedHashSet.add(5);
        linkedHashSet.add(4);
        linkedHashSet.add(7);

        System.out.println(linkedHashSet);
        linkedHashSet.remove(4);
        System.out.println(linkedHashSet.contains(4));

    }

}
