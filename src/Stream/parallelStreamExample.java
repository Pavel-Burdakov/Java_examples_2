package Stream;

/*
* Parallel Stream - это возможность использовать несколько ядер процессора
* при выполнении каких - либо операций с потоками.
* Использовать нужно, когда данных очень много
* на малых объемах будет работать медленнее отдельного потока
* */

import java.util.ArrayList;
import java.util.List;

public class parallelStreamExample {

    public static void main(String[] args) {

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.0);
        doubleList.add(5.0);
        doubleList.add(1.0);
        doubleList.add(0.25);

        double sumresult = doubleList.parallelStream()
                .reduce((accumulator, element)->accumulator+element)
                .get();

        System.out.println(sumresult);

        System.out.println("_---------------");

        double deivisionResult = doubleList.stream()
                .reduce((accumulator, element)->accumulator/element)
                .get();
        System.out.println(deivisionResult);

        // в случае с делением результат будет неверным
        // поэтому в задачах, где порядок элемента важен
        // нельзя использовать параллельность
        deivisionResult = doubleList.parallelStream()
                .reduce((accumulator, element)->accumulator/element)
                .get();
        System.out.println(deivisionResult);



    }

}
