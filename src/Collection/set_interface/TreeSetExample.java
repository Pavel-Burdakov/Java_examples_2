package Collection.set_interface;


/*
Хранит элементы в отсортированном по возрастанию порядке
в основе лежит TreeMap
у элементов данного TreeMap ключи - это элементы TreeSet,
значения - это константа заглушка
 - не допускает дубликаты
 - не допускает null
 */
/*
если а.eqals(b) - > true то
a.compareTo(b) -> 0
* */


import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {

        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(6);
        treeSet.add(4);
        treeSet.add(7);

        System.out.println(treeSet);
        System.out.println(treeSet.contains(3));

        Student st1 = new Student ("Marty", 5);
        Student st2 = new Student ("Emmet", 4);
        Student st3 = new Student ("Harry", 5);
        Student st4 = new Student ("Monte-Crysto", 2);

        // аналогично TreeMap если элементы - объекты класса
        // этот класс должен имплементировать Comparable
        TreeSet<Student> treeSet2 = new TreeSet<>();
        treeSet2.add(st1);
        treeSet2.add(st2);
        treeSet2.add(st3);
        treeSet2.add(st4);

        System.out.println(treeSet2);


        Student st5 = new Student("Zaur", 2);
        Student st6 = new Student("Igor", 4);

        System.out.println(treeSet2.first());
        System.out.println(treeSet2.last());

        // все кто ниже st5 по курсу
        System.out.println(treeSet2.headSet(st5));

        // все кто больше или равен st5
        System.out.println(treeSet2.tailSet(st5));

        // множество элементы которого между показателями
        System.out.println(treeSet2.subSet(st5, st6));







    }

}



class Student implements Comparable<Student> {
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.course-o.course != 0) {return this.course-o.course;}
        else {return this.name.compareTo(o.name);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }
}