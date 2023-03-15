package Comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// примеры сортировки объектов с использованием интерефейса Comparable


class Employee implements Comparable<Employee>{

    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary)  {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
//        if (this.id == o.id){return 0;}
//        else if (this.id<o.id){return -1;}
//        else {return 1;}
//---------------------------------------------------------
        //return this.id - o.id;
        int return_value =  this.name.compareTo(o.name);
        if (return_value == 0){
            return_value = this.surname.compareTo(o.surname);

        }
        return return_value;
    }
}


public class Test1 {

    public static void main(String[] args) {

        //List<String> list = new ArrayList<>();

        List<Employee> list = new ArrayList<>();

        Employee emp1 = new Employee(100,"Zaur", "Tregulov", 12345);
        Employee emp2 = new Employee(15,"Ivan", "Petrov", 23456);
        Employee emp3 = new Employee(123,"Ivan", "Sidorov", 13459);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);


        System.out.println("Before sorting \n" + list);
        Collections.sort(list);
        System.out.println("After sorting \n" + list);
        //




        
    }


}
