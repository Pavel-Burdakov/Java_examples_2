package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {

    private String name;
    private String surname;
    private char sex;
    private int age;
    private int course;
    private double avg_grade;

    public Student(String name, String surname, char sex, int age, int course, double avg_grade) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avg_grade = avg_grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avg_grade=" + avg_grade +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public double getAvg_grade() {
        return avg_grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAvg_grade(double avg_grade) {
        this.avg_grade = avg_grade;
    }
}

public class filterExample {
    public static void main(String[] args) {

      Student st1 = new Student("Zaur", "Tregulov", 'm', 20, 5, 9.5);
      Student st2 = new Student("Marty", "McFly", 'm', 21, 4, 9.1);
      Student st3 = new Student("Germiona", "Grey", 'f', 19, 1, 9.9);
      Student st4 = new Student("Dart", "Veyder", 'm', 30, 5, 5.5);
      Student st5 = new Student("Alisa", "Selezen", 'f', 18, 2, 8.9);

      List<Student> my_list = new ArrayList<>();
      my_list.add(st1);
      my_list.add(st2);
      my_list.add(st3);
      my_list.add(st4);
      my_list.add(st5);


      // пример на method chaining
       System.out.println("-----------------");
      my_list.stream().map(element->
      {
          element.setName(element.getName().toUpperCase());
          return element;
      })
              .filter(element->element.getSex() == 'f')
              .sorted((x, y)->x.getAge() - y.getAge())
              .forEach(element-> System.out.println(element));

        System.out.println("------avg grade------");
        double avg = my_list.stream().mapToDouble(el->el.getAvg_grade())
                .average().getAsDouble();


        System.out.println("------first student------");
        Student firstStudent = my_list.stream().map(element->
                {
                    element.setName(element.getName().toUpperCase());
                    return element;
                })
                .filter(element->element.getSex() == 'f')
                .sorted((x, y)->x.getAge() - y.getAge())
                .findFirst().get();
        System.out.println(firstStudent);




        System.out.println("-----min student-----");
        Student minStudent = my_list.stream().min(
                (x, y)-> x.getAge()-y.getAge()).get();
        System.out.println(minStudent);

        System.out.println("------limit list-----------");
       my_list.stream().filter(element->element.getAge()>19).limit(2)
                .forEach(System.out::println);

       //  limit оставляет первые жлементы потоко skip пропускает первые элементы потока



        System.out.println("-------map to int----------");

        List<Integer> couurses = my_list.stream()
                .mapToInt(el->el.getCourse())
                .boxed()// чтобы int стал Integer-ом иначе не запишется
                .collect(Collectors.toList());
        System.out.println(couurses);




        System.out.println("-------filter list----------");


      my_list = my_list.stream().filter(element->
              element.getAge()>20 && element.getAvg_grade()>9).collect(Collectors.toList());

      System.out.println(my_list);

        // поток можно создавать не из коллекции, а с нуля
        Stream<Student> studentStream = Stream.of(st1, st2, st3, st4, st5);

        my_list = my_list.stream().sorted((x,y)->
                x.getName().compareTo(y.getName())).collect(Collectors.toList());

        System.out.println(my_list);










    }
}
