package Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentInfo {

    void testStudent(ArrayList<Student> AL, Predicate<Student> PR){

        for (Student st: AL){

            if (PR.test(st)){
                System.out.println(st);
            }

        }

    }




}


// функциональный интрефейс содержит один абстрактный метод
// в принципе, он тут был для иллюстрации заменим на predicate

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



        //SI.testStudent(my_list, new checkOverGrade());

        System.out.println("-------------------------------------");


        // чтобы не создавать объект который имплементирует интерфейс и не описывать его
        // класс, правильнее создать объект анонимного класса
/*        SI.testStudent(my_list, new studentChecks() {
            @Override
            public boolean check(Student s) {
                return s.age<20;
            }
        });*/

        System.out.println("-------------------------------------");

        // вариант с лямбда
        // вместо того чтобы создавать класс, который имплеменитрует интерфейс и оверрайдить  его метод
        // после чего создавать объект этого класс и вставлять его в параметр метода
        SI.testStudent(my_list, (Student s) -> {return s.age<20;});
        System.out.println("-------------------------------------");

        // короткая запись неприменима, если справа олее одного стэйтмента
        SI.testStudent(my_list,  s ->  s.age<20);


        /*
        * в лямбда выражении справа от оператора стрелка находится тело метода, которое
        * было бы у метода соответствующего класса,
        * имплементировавшего наш интерфейс с единственным методом*/

        /*
        * если у метода нет парамтров то слева указываются обычные скобки
        *
        * */

        System.out.println("-------------------------------------");
        // еще вариант написания
/*        studentChecks sc = (Student s) -> {return s.age<20;};
        SI.testStudent(my_list, sc);

        Collections.sort(my_list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.course - o2.course;
            }

        });*/
        System.out.println("-------------------------------------");
        System.out.println(my_list);

        Collections.sort(my_list, (Student s1, Student s2)->{return s1.course - s2.course;});
        System.out.println("-------------------------------------");
        System.out.println(my_list);




        // иллюстрация and predicate
        Predicate<Student>p1 = student -> student.avg_grade>9;
        Predicate<Student>p2 = student -> student.sex == 'f';
        System.out.println("-------------------------------------");
        SI.testStudent(my_list, p1.and(p2));
        SI.testStudent(my_list, p1.or(p2));

        // отрицание принципов проверки P1
        SI.testStudent(my_list, p1.negate());



        // иллюстрация интерфейса function
        // на примере нахождения среднего
        Function<Student, Double> f = student -> student.avg_grade;

        double avg_res = avgOf(my_list, element-> element.avg_grade);

        System.out.println("Средняя оценка всех студентов " + avg_res);



    }

    private static double avgOf(List<Student> studentList, Function<Student, Double> studentFunction){
        double result = 0;
        // к результату добавляем то что вернет метод apply функционального интерфейса
        // а что он будет делать будет описываться при вызове лямбдой
        for (Student st: studentList){
            result = result + studentFunction.apply(st);
        }
        // а теперь для нахождения среднего разделим результат на размер листа
        result = result / studentList.size();
        return result;



    }



}
