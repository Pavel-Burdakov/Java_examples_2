package Lambda;

public class Student {

    String name;
    String surname;
    char sex;
    int age;
    int course;
    double avg_grade;

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
}
