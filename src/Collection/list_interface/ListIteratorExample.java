package Collection.list_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


/*
* ListIterator в отличии от Iterator может "ходить"
* в обе стороны
* пример с определением полиндрома
* у него есть методы hasPrevios и previous
* */



public class ListIteratorExample {

    public static void main(String[] args) {

        String s = "dovod";
        List<Character> list = new ArrayList<>();

        // преобразуем String в List из Char
        for (char ch: s.toCharArray()){
            list.add(ch);
        }

        ListIterator<Character> iterater = list.listIterator();
        ListIterator<Character> reverseiterator = list.listIterator(list.size());

        boolean isPalindrom = true;

        while (iterater.hasNext() && reverseiterator.hasPrevious()){

            if (iterater.next() != reverseiterator.previous()){

                isPalindrom = false;
                break;

            }


        }

        if (isPalindrom)
            System.out.println(s+" is polindrome");
        else
            System.out.println(s+" is not polindrome");






    }


}
