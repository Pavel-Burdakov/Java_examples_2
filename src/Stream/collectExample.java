package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class collectExample {

    public static void main(String[] args) {

        Student st1 = new Student("Zaur", "Tregulov", 'm', 20, 5, 9.5);
        Student st2 = new Student("Marty", "McFly", 'm', 21, 4, 9.1);
        Student st3 = new Student("Germiona", "Grey", 'f', 19, 1, 9.9);
        Student st4 = new Student("Dart", "Veyder", 'm', 30, 5, 5.5);
        Student st5 = new Student("Alisa", "Selezen", 'f', 18, 2, 8.9);

        List<Student> studentList = new ArrayList<>();

        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);

        // Сгруппировали студентов в листы по курсу,
        // а сам ключ - это курс

       Map<Integer, List<Student>> listMap = studentList.stream().map(element->{element
                .setName(element.getName().toUpperCase());
                return element;
        })
                .collect(Collectors.groupingBy(element->element.getCourse()));



        for (Map.Entry<Integer, List<Student>> entry: listMap.entrySet()){

            System.out.println(entry.getKey() + ": " + entry.getValue().toString());


        }


        System.out.println("-------------------------------------");

        Map<Boolean, List<Student>>listMap1 = studentList.stream()
                .collect(Collectors.partitioningBy(element->element.getAvg_grade()>7));

        for (Map.Entry<Boolean, List<Student>> entry: listMap1.entrySet()){
            System.out.println(entry.getKey() + ": "+ entry.getValue());

        }


    }

}
