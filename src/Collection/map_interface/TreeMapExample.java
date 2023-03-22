package Collection.map_interface;

import javax.swing.tree.TreeCellRenderer;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

// not synchronized collection

public class TreeMapExample {

    public static void main(String[] args) {

        Students st1 = new Students("Zaur", "Tregulov", 5);
        Students st2 = new Students("Ivan", "Ivanov", 1);
        Students st3 = new Students("Mark", "Tven", 3);
        Students st4 = new Students("Marti", "Mcfly", 4);
        Students st5 = new Students("Harry", "Potter", 2);
        Students st6 = new Students("Dart", "Veyder", 3);
        Students st7 = new Students("Petr", "Petrov", 1);


        TreeMap<Double, Students> treeMap = new TreeMap<>();

        treeMap.put(5.8, st7);
        treeMap.put(5.1, st1);
        treeMap.put(8.2, st6);
        treeMap.put(7.4, st5);
        treeMap.put(6.1, st2);
        treeMap.put(9.1, st3);
        treeMap.put(8.8, st4);


        System.out.println(treeMap);

        /*
        * Элементы хранятся в отсортированном по возрастанию ключа порядке
        * значение в treeMap могут быть не уникальными, ключи должны быть уникальными
        * при добавлении нового элемента с тем же ключом произойдет замена
        *
        * Основная цель TreeMap нахождение отрезков
        */

        System.out.println(treeMap.get(5.1));

        // вывод по убыванию ключа
        System.out.println(treeMap.descendingMap());

        // вывод всех у кого значение ключа больше заданного
        System.out.println(treeMap.tailMap(7.1));

        // вывод всех у кого значение ключа меньше заданного
        System.out.println(treeMap.headMap(7.1));

        // последнее значение
        System.out.println(treeMap.lastEntry());

        //первое
        System.out.println(treeMap.firstEntry());

        // в качестве ключа не может быть класс который не имплементирует
        // comparable


        System.out.println("-------------------------------------------");


        TreeMap<Students, Double> treeMap1 = new TreeMap<>();

        treeMap1.put(st5, 5.8);
        treeMap1.put(st6, 6.8);
        treeMap1.put(st7, 5.5);
        treeMap1.put(st3, 7.7);
        treeMap1.put(st4, 7.2);
        treeMap1.put(st1, 6.1);
        treeMap1.put(st2, 5.8);

        System.out.println(treeMap1);


        // либо при создании TreeMap нужно перезаписать Comparator

        TreeMap<Students, Double> treeMap2 = new TreeMap<>(new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        /*
        * при работе с Treemap нет необходимости переопределять
        * hashCode and equals для объекта ключа, потому что
        * поиск идет по compareTo
        * Это не относится к значениям
        */










    }









}


final class Students implements Comparable<Students>{

    final String name;
    final String surname;
    int course;

    public Students(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }


    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return course == students.course && Objects.equals(name, students.name) && Objects.equals(surname, students.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }

    @Override
    public int compareTo(Students o) {
        return this.name.compareTo(o.name);
    }
}
