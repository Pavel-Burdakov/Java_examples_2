package Generics;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedClass {

    public static void main(String[] args) {
        Info<String>info1 = new Info<>("Hallo");
        System.out.println(info1);
        String s1 = info1.getValue();

        Info<Integer>info2= new Info<>(18);
        System.out.println(info2);
        Integer i1 = info2.getValue();

        // вместо знака ? может быть подставлен любой класс
        // wildcard

        List<?> list = new ArrayList<String>();
        // в list с типом wildcard не получится добавлять элементы
        // из соображений type safe, например
        // list.add(" hallo");

        // пример использования wildcard
        List<Double> l1 = new ArrayList<>();
        l1.add(3.14);
        l1.add(3.16);
        l1.add(3.15);

        List<String> l2 = new ArrayList<>();
        l2.add("hallo");
        l2.add("bye");
        l2.add("good");

        showList(l1);
        showList(l2);

        // элементами могут быть Number и любые его наследники
        List<? extends Number> l3 = new ArrayList<Integer>();

        //элементами могут быть Nember и любые его "предки"
        List<? super Number> l4 = new ArrayList<Object>();

        ArrayList<Double> L5 = new ArrayList<>();
        L5.add(3.41);
        L5.add(3.14);
        L5.add(3.16);
        L5.add(3.15);

        System.out.println(sum(L5));




    }

    static void showList(List<?> list){
        System.out.println("my elements - > " + list);
    }
    // в качестве параметров можно использовать только number и его sub классы
    // bounded wild cards
    public static double sum (ArrayList<? extends Number> a1){
        double sum = 0;

        for (Number n: a1) {
            sum += n.doubleValue();
        }
        return sum;

        }




    }






class Info<T>{

    private T value; // не может быть статичной

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{[" + value + "]}";
    }


    public T getValue() {
        return value;
    }
}

// в этом варианте вместо Т можно поставить уж е не любой класс,
// а только наследника number
// таким образом, можно ограничивать классы подходящие под тип Т


class Info2<T extends Number>{

    private T value; // не может быть статичной

    public Info2(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{[" + value + "]}";
    }


    public T getValue() {
        return value;
    }
}

// type erasure

/*
Для JVM <T> не существует, вместо нее подставляется object
если мы используем наследование, то класс от которого наследуемся.
Run time вся информация о generics удаляется
Поэтому мы не можем создавать overloaded методы с использованием generics
Также не получится делать Override в sub классах в методах с generics

 */

// в ограничениях можно указывать, что класс должен имплементировать еще
// интерфейсы, но вначале extends
class info3<T extends Number & I1 & I2>{

}

interface I1{

}

interface I2{

}