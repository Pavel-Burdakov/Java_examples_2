package Collection.map_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapExample2 {

    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();

        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Tirlim", "MeBumBum", 1);
        Student st3 = new Student("BumBum", "Tirlim", 3);

        map.put(st1, 7.5);
        map.put(st2, 3.2);
        map.put(st3, 9.9);

        System.out.println(map);
        /*
        * пока метод hashCode не переопределен
        * .containsKey будет возвращать false, несмотря на то, что метод
        * equals переопределен и возвращает true
        * в Java Хэширование - это преобразование с помощью метода hashCode
        * любого объекта в int
        *
        * Если мы переопредели .hashCose, но не переопределили equals,
        * то результат все равно будет false, потому что сравнение в
        * java идет сначала по .hashCode, а уже потом по equals
        *
        * т.е. оба эти методы должны быть правильно переопределены
        *
        * если по equals объекты равны, то и hashCode должен быть одинаковым
        *
        * если по equals объекты не равны, то hashCode необязательно должен быть разным
        * потому что у int которое возвращается методом есть предел верхние и нижние границы
        * коллизия все равно может быть
        *
        * hashCode работает гораздо быстрее equals
        *
        * даже если его не переопределять он есть, но будет работать не корректно
        *
        * */
        Student st4 = new Student("Zaur", "Tregulov", 3);
        Student st5 = new Student("Leonardo", "Da Vinci", 5);


        boolean result = map.containsKey(st4);
        System.out.println(result);
        System.out.println(st1.equals(st4));

        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());
        System.out.println(st4.hashCode());
        System.out.println(st5.hashCode());

    }

}


class Student{

    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);

        // альтернативная хреновая реализация hashcode
        // у разных объектов возвращается один haсhcode - это коллизия
        //return name.length() + surname.length()+course;

        // умножений на простые числа уменьшит количество коллизий,
        // но тоже не идеально

        // return name.length()*5 + surname.length()*7+course*53;
    }
}
