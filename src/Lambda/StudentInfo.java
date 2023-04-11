package Lambda;

import java.util.ArrayList;

public class StudentInfo {

    void testStudent(ArrayList<Student> AL, studentChecks SC){

        for (Student st: AL){

            if (SC.check(st)){
                System.out.println(st);
            }

        }

    }




}


// функциональный интрефейс содержит один абстрактный метод
interface studentChecks{

    boolean check(Student s);

}

class checkOverGrade implements studentChecks{

    @Override
    public boolean check(Student s) {
        return s.avg_grade>9;
    }
}





class test {


    public static void main(String[] args) {

        Student st1 = new Student("Zaur", "Tregulov", 'm', 20, 5, 9.5);
        Student st2 = new Student("Marty", "McFly", 'm', 21, 4, 9.1);
        Student st3 = new Student("Germiona", "Grey", 'f', 19, 1, 9.9);
        Student st4 = new Student("Dart", "Veyder", 'm', 30, 5, 5.5);
        Student st5 = new Student("Alisa", "Selezen", 'f', 18, 2, 8.9);

        ArrayList<Student> my_list = new ArrayList<>();
        my_list.add(st1);
        my_list.add(st2);
        my_list.add(st3);
        my_list.add(st4);
        my_list.add(st5);

        StudentInfo SI= new StudentInfo();



        SI.testStudent(my_list, new checkOverGrade());

        System.out.println("-------------------------------------");


        // чтобы не создавать объект который имплементирует интерфейс и не описывать его
        // класс, правильнее создать объект анонимного класса
        SI.testStudent(my_list, new studentChecks() {
            @Override
            public boolean check(Student s) {
                return s.age<20;
            }
        });

        System.out.println("-------------------------------------");

        // вариант с лямбда
        // вместо того чтобы создавать класс, который имплеменитрует интерфейс и оверрайдить  его метод
        // после чего создавать объект этого класс и вставлять его в параметр метода
        SI.testStudent(my_list, (Student s) -> {return s.age<20;});




    }



}
