package Collection.queue_interface;



import java.util.Objects;
import java.util.PriorityQueue;



        /*

        Priority Queue
        в первую очередь используется элемент приоритет которого выше.
        Естественная сортировка для string integer и т.п. от меньшего к большему
        Для экземпляров класса нужно иметь метод компаратор.
        
        При выводе на экран у элементов нет сортировки по приоритету

         */


public class PriorityQueue_example {

    public static void main(String[] args) {

        StudentTest st1 = new StudentTest ("Marty", 5);
        StudentTest st2 = new StudentTest ("Emmet", 4);
        StudentTest st3 = new StudentTest ("Harry", 5);
        StudentTest st4 = new StudentTest ("Monte-Crysto", 2);

        PriorityQueue<StudentTest> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(st1);
        priorityQueue.add(st2);
        priorityQueue.add(st3);
        priorityQueue.add(st4);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());



    }
}


class StudentTest implements Comparable<StudentTest> {
    String name;
    int course;

    public StudentTest(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentTest{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public int compareTo(StudentTest o) {
        if (this.course-o.course != 0) {return this.course-o.course;}
        else {return this.name.compareTo(o.name);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTest that = (StudentTest) o;
        return course == that.course && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }


    }

