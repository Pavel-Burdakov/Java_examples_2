package Collection.queue_interface;

/*
Queue - интерфейс очередь.
- FIFO
linked list имплементирует deque, который является наследником
queue
 */


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LikedList_example {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        /* если бы очередь была ограниченная, например 4-мя элементами,
        то при использовании метода add для добавления 5го элемента
        выбрасывался бы exception, при использовании offer ничего бы
        не выбрасывалось, просто элемент не добавлялся
         */

        queue.add("Zaur");
        queue.add("Marty");
        queue.add("Dart");
        queue.offer("Emmet");
        System.out.println(queue);

        // удаляется первый элемент в очереди
        // если элементы в очереди закончатся, то вы бросить exception
        System.out.println(queue.remove());
        System.out.println(queue);

        //аналогично remove, но exception не выбросится, вернет null
        //если удалять дальше некого
        System.out.println(queue.poll());
        System.out.println(queue);

        // показывает первый элемент в очереди
        // если первого элемента уж нет очередь пуста, то выбросится exception
        System.out.println(queue.element());

        // аналогично, но вместо exception null
        System.out.println(queue.peek());

        // можно удалять и из середины, но так делать не надо
        // лучше использовать другие коллекции
        // queue.remove("Dart");







    }


}
