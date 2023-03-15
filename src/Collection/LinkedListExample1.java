package Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Student2{
    String name;
    int course;

    public Student2(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }
}

public class LinkedListExample1 {

    public static void main(String[] args) {


        Student2 st1 = new Student2("Ivan", 20);
        Student2 st2 = new Student2("Petr", 19);
        Student2 st3 = new Student2("Oleg", 21);
        Student2 st4 = new Student2("Elena", 18);
        Student2 st5 = new Student2("Olga", 19);
        Student2 st6 = new Student2("Ivan", 20);
        Student2 st7 = new Student2("Igor", 17);

        LinkedList<Student2> student2LinkedList = new LinkedList<>();
        student2LinkedList.add(st1);
        student2LinkedList.add(st2);
        student2LinkedList.add(st3);
        student2LinkedList.add(st4);
        student2LinkedList.add(st5);
        student2LinkedList.add(st6);

        System.out.println("LinkedList = "+ student2LinkedList);
        /*
        * linkedlist - это звенья одной цепи (связный список), у каждого элемента есть
        * адрес предыдущего и следующего элементов
        * при необходимости обратиться к какому - либо элементу,
        * будут перебираться все элементы с самого начала!
        * dovbly linkedlist знает адрес начала и конца цепи и если элемент ближе
        * к концу, то поиск будет с конца.
        * singly linkedlist - каждый элемент знает только адрес следующего
        * в java он dovbly
        * */

        // перебираются все элементы с нулевого пока не найдется второй
        System.out.println(student2LinkedList.get(2));

        /*
        * добавлять в определенную позицию можно
        * в этом преимущество над листом, при добавлении элемента в заданную позицию
        * только добавляются ссылки (в предыдущем меняется ссылка на следующий,
        * в следующем на предыдущий, в новом прописываются две ссылки)
        * в случае же обычного листа передвигались бы все элементы (когда их много
        * это создавало бы большую нагрузку)
        * аналогичная история с удалением элементов, при этом удаляемый объект
        * исчезает из цепочки, но остается в памяти
        */
        student2LinkedList.add(1, st7);
        System.out.println(student2LinkedList);


        System.out.println();

        /* итого если часто происходит поиск элементов
        * лучше использовать ArrayList, если чаще операции замены элементов,
        * то эффективнее LinkedList
         */


    }

}
