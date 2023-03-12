package comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// примеры сортировки объектов с использованием интерефейса Comparable
// и Comparator

// естесственная соритировка происходит по id

// в случае пользовательской (не естесственной) сортировки используется comparator


class Employee1 implements Comparable<Employee1>{

    int id;
    String name;
    String surname;
    int salary;

    public Employee1(int id, String name, String surname, int salary)  {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee1 o) {
//        if (this.id == o.id){return 0;}
//        else if (this.id<o.id){return -1;}
//        else {return 1;}
//---------------------------------------------------------
        return this.id - o.id;
//        int return_value =  this.name.compareTo(o.name);
//        if (return_value == 0){
//            return_value = this.surname.compareTo(o.surname);
//
//        }
//        return return_value;
    }
}


class NameComparator implements Comparator<Employee1>{
    @Override
    public int compare(Employee1 o1, Employee1 o2) {
        return o1.name.compareTo(o2.name);
    }
}

class SalaryComparator implements Comparator<Employee1>{
    @Override
    public int compare(Employee1 o1, Employee1 o2) {
        return o1.salary-o2.salary;
    }
}





public class Test2 {

    public static void main(String[] args) {

        //List<String> list = new ArrayList<>();

        List<Employee1> list = new ArrayList<>();

        Employee1 emp1 = new Employee1(100,"Zaur", "Tregulov", 12345);
        Employee1 emp2 = new Employee1(15,"Ivan", "Petrov", 23456);
        Employee1 emp3 = new Employee1(123,"Ivan", "Sidorov", 13459);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);


        System.out.println("Before sorting \n" + list);
        Collections.sort(list);
        System.out.println("After sorting \n" + list);
        System.out.println("------------------------------------------------");

        Collections.sort(list, new SalaryComparator());





    }


}

