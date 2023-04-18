package Stream;

import java.util.ArrayList;
import java.util.List;

public class flatMapExample {

    public static void main(String[] args) {

        Student st1 = new Student("Zaur", "Tregulov", 'm', 20, 5, 9.5);
        Student st2 = new Student("Marty", "McFly", 'm', 21, 4, 9.1);
        Student st3 = new Student("Germiona", "Grey", 'f', 19, 1, 9.9);
        Student st4 = new Student("Dart", "Veyder", 'm', 30, 5, 5.5);
        Student st5 = new Student("Alisa", "Selezen", 'f', 18, 2, 8.9);


        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Applied mathematics");

        f1.addStudentToFaculty(st1);
        f1.addStudentToFaculty(st2);
        f1.addStudentToFaculty(st3);
        f2.addStudentToFaculty(st3);
        f2.addStudentToFaculty(st4);

        List<Faculty>facultyList = new ArrayList<>();

        facultyList.add(f1);
        facultyList.add(f2);

        // flatMap нужен когда нам необходимо поработать не с элементами коллекции,
        // а с элементами элементов коллекции

        facultyList.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
                .forEach(e-> System.out.println(e.getName()));


    }

}


class Faculty{

    String name;
    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        studentsOnFaculty = new ArrayList<>();
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void addStudentToFaculty (Student st){

        studentsOnFaculty.add(st);

    }


}
