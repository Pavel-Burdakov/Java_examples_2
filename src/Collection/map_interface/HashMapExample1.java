package Collection.map_interface;


import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample1 {


    public static void main(String[] args) {
        // создаем map
        // в паре ключ значение ключ - integer, значение string
        Map<Integer, String> map1= new HashMap<>();

        // элементы добавляются методом put
        map1.put (1003, "Ivan Petrov");
        map1.put (1014, "Petr Ivanov");
        map1.put (1027, "Tigr Tigrov");
        map1.put (1030, "Kisa Myshkina");

        // порядок добавления не хранится

        // ключи должны быть уникальными, значения не обязательно
        // если мы пытаемся вставить элемент который уже есть,
        // то ключ остается уникальным, а значение перезаписыватся

        System.out.println(map1);

        map1.put (1027, "Tirlim Bombom");
        System.out.println(map1);

        map1.put (null, "Tirlim Bombom");
        map1.put (null, "Tirlim NeBumBum");

        System.out.println(map1);

        // добавить если такого элемента нет
        map1.putIfAbsent(1003, "Rikardo Dias");
        System.out.println(map1);

        System.out.println(map1.get(1014));
        map1.remove(1027);

        // возвращает boolean
        map1.containsValue("Ivan Petrov");
        map1.containsKey(1027);

        // возвращает множество всех ключей
        System.out.println(map1.keySet());

        //возвращает множество значений
        System.out.println(map1.values());

        // ключ и значение могут быть любых типов, в том числе классами, и могут совпадать



    }

}
