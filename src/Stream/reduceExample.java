package Stream;

/*уменьшение количества элементов в потоке до одного
* например, произведение сумма и т.g/*/

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class reduceExample {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(8);
        integerList.add(2);
        integerList.add(4);

        //  первое значение потока присваивается аккумулятору второе элементу
        //  далее происходит их перемножение и передача значения аккумулятору,
        //  со второго шага значения назначаются элементу, он перемножается с аккумулятором
        //  и значение снова передается в аккумулятор
        //  и т.д.

        // reduce возвращает optional (является контейнером для нашего значения)
        // может содержать null , чтобы получить значение используем метод get
        int result = integerList.stream().reduce((accumulator, element)->
                accumulator*element).get();
        System.out.println(result);

        // чтобы проверить, что в optional не null, может понадобиться если после операции над
        // stream у нас в потоке нет элементов, а мы их пытаемся вывести.

        List<Integer> integerList1 = new ArrayList<>();
        Optional<Integer> optionalInteger = integerList1.stream().reduce((accumulator, element)->
                accumulator*element);

        if (optionalInteger.isPresent()) {
            System.out.println(optionalInteger.get());
        }
        else
        {
            System.out.println("not present");
        }


        // 1 в данном примере = это начальное значение аккумулятора
        // тут null получить не получится, поэтому возвращается не null, а int
        // и get не нужен
        int result2 = integerList.stream().reduce(1, (accumulator, element)->
                accumulator*element);


        // пример с конкатенацией

        List<String> stringList = new ArrayList<>();
        stringList.add("First");
        stringList.add("Head");
        stringList.add("Learning");
        stringList.add("New");
        stringList.add("ok");

        String res = stringList.stream().reduce((a, e)->
                a+" "+e).get();
        System.out.println(res);




    }


}
