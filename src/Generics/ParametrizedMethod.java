package Generics;


import java.util.ArrayList;

class GenMethod{

    // <T> - указание на то что мы используем дженерики в методе
    // Т - возвращаемый тип данных
    // если класс уже параметризирован, то указывать <T>  не обязательно
    public static <T> T getSecondElement (ArrayList<T> a1){

        return a1.get(1);

    }

}

public class ParametrizedMethod {

    public static void main(String[] args) {

        ArrayList<Integer> aL1 = new ArrayList<>();
        aL1.add(10);
        aL1.add(11);
        aL1.add(12);
        aL1.add(8);

        int a = GenMethod.getSecondElement(aL1);
        System.out.println(a);

        ArrayList<String> aL2 = new ArrayList<>();
        aL2.add("abc");
        aL2.add("def");
        aL2.add("ghi");

        String s = GenMethod.getSecondElement(aL2);
        System.out.println(s);




    }

}
