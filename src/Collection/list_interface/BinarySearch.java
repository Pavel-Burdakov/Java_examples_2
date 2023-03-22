package Collection.list_interface;

import java.util.*;


/*
* для использования binary search необходимо чтобы лист был отсортирован
* на каждом шаге лист делится пополам и средний элемент сравнивается с искомым
* если больше то делится на два предыдущая часть
* и так далее, это значительно сокращает количество итераций для поиска
* чем если бы мы перебирали каждый элемент
* если элемент не найден возвращается отрицательное число, если найден,
* то индекс первого найденного
*  */

public class BinarySearch {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        Random r = new Random();

        for (int i=0; i<30; i++){

            list.add(r.nextInt(35));

        }
        Collections.sort(list);
        System.out.println(list);

        int index = Collections.binarySearch(list, 15);
        System.out.println(index);

        System.out.println("______________________________________");

        // сравним сотрудников по id,чей больше тот и больше

        Employee st1 = new Employee("Ivan", 120, 100);
        Employee st2 = new Employee("Petr", 105, 120);
        Employee st3 = new Employee("Oleg", 109, 150);
        Employee st4 = new Employee("Elena", 107, 125);
        Employee st5 = new Employee("Olga", 101, 145);
        Employee st6 = new Employee("Ivan", 101, 119);


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(st1);
        employeeList.add(st2);
        employeeList.add(st3);
        employeeList.add(st4);
        employeeList.add(st5);
        employeeList.add(st6);

        System.out.println(employeeList);

        // чтобы отсортировать list с объектами, нужно сначала определить как будем
        // его сортировать. имплементируем интерфейс Comparable и
        // перезапишем его метод в классе Employee

        Collections.sort(employeeList);
        System.out.println(employeeList);

        // теперь найдем индекс какого - нибудь элемента
        // в методе CompareTo описано сравнение только по id и по имени,
        // поэтому поле salary в поиске не учитывается
        int index2 = Collections.binarySearch(employeeList,
                new Employee("Elena", 107, 0));
        System.out.println(index2);


        // для массивов binary search применим
        System.out.println("______________________________________");

        int[] array= {-3, 8, 9, 6, -4, 3, 0, 9, -1, 2, 19, 4};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int index3 = Arrays.binarySearch(array, 19);
        System.out.println(index3);

        System.out.println("______________________________________");

        // отзерекалить массив
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        // перемешать массив
        Collections.shuffle(list);
        System.out.println(list);

        System.out.println("______________________________________");






    }

}


class Employee implements Comparable<Employee>{
    String name;
    int id;
    int salary;


    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        int return_value = this.id - o.id;
        if (return_value == 0){
            return_value = this.name.compareTo(o.name);
        }
        return return_value;
    }
}
