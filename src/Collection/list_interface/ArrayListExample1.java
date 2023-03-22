package Collection.list_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Student{

    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }


}

public class ArrayListExample1 {




    public static void main(String[] args) {

        // без generics части можно добавлять элементы любого типа
        // потому что в основе массив object, но так делать не надо,
        // использовать generics
        ArrayList AL1= new ArrayList();
        AL1.add(1);
        AL1.add("OK");
        AL1.add("5.555");



        System.out.println(AL1);

        // здесь сразу можно указать емкость
        // не путать с размером
        ArrayList<String> AL2 = new ArrayList<>(200);
        AL2.add("Hallo");
        AL2.add("Hallo");
        AL2.add("OOK");
        AL2.add(1, "first"); // с указанием места куда поставить
        AL2.set(1, "FIRST!"); //замена элемента по индексу

        AL2.indexOf("Hallo"); // возвращает первое вхождение
        AL2.lastIndexOf("Hallo"); // последнее вхождение
        AL2.size();
        AL2.isEmpty();

        AL2.contains("OOK"); // содерэит ли элемент в массиве использует eqalse


        AL2.remove(1);
        AL2.remove("OOK");

        // ArrayList имплементирует Lst, поэтому возможно такое написание
        // в данном примере создается новый массив AL3 в который помещаются элементы AL2
        List<String> AL3 = new ArrayList<>(AL2);
        System.out.println(AL2);
        System.out.println(AL3);
        System.out.println(AL2.equals(AL3));
        System.out.println(AL2==AL3);

        //Arralist нельяз создавать из примитвных типов данных
        // использовать wrapper классы


        System.out.println("----------------------------------");

        List<String> AL4 = new ArrayList<>();
        AL4.add("Hallo");
        AL4.add("OOK");

        List<String> AL5 = new ArrayList<>();
        AL5.add("Privet");
        AL5.add("Go");

        AL4.addAll(1, AL5);

        System.out.println("----------------------------------");

        List<Student> studentList= new ArrayList<>();
        Student st1 = new Student("Ivan", 20);
        Student st2 = new Student("Petr", 19);
        Student st3 = new Student("Oleg", 21);
        Student st4 = new Student("Elena", 18);
        Student st5 = new Student("Olga", 19);

        Student st6 = new Student("Ivan", 20);

        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);

        System.out.println(studentList);

        // если метод equalse не перезаписан, то сравниваются адреса,
        // то есть на один и тот же объект ссылаются st6 и какие - либо записей
        // листа, т.к. такого элемента нет, ничего не удаляется

        // если перезаписан, то сравниваются содержимое элементов,
        // в нашем случае будет удален первый элемент
        studentList.remove(st6);


        System.out.println("----------------------------------");
        System.out.println(studentList);





    }

}
