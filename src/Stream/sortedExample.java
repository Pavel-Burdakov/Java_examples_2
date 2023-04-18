package Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class sortedExample {

    public static void main(String[] args) {

        int [] arr = {3,4,1,8,7,4,9,6,0,1,4,5,2};
        arr = Arrays.stream(arr).sorted().toArray();
        System.out.println(arr);

        Stream<Integer> stream = Stream.of(1,2,3,4,5,5);
        Stream<Integer> stream1 = Stream.of(6,7,8,9,9);

        /*
        * метод concat статический, не может использоваться в цепочке*/
        Stream<Integer> stream2 = Stream.concat(stream, stream1);
        //stream2.forEach(System.out::println);

        // уникальные значения в потоке
        //Arrays.stream(arr).distinct().forEach(System.out::println);

        // возвращает long
        //System.out.println(stream2.count());

        // переиспользовать тот же stream нельзя, чтобы использовать следующую строку,
        // нужно убрать предыдущую

        //System.out.println(stream2.distinct().count());

        //peek для просмотра, что происходит на каком - либо этапе method chaining

        System.out.println(stream2.distinct().peek(System.out::println).count());



    }

}
