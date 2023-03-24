package Collection.queue_interface;

/*

Deque - двунаправленная очередь
в такой очереди элемент может быть использован с обоих концов

данный интерфейс реализуется классами LinkedList и ArrayDeque


 */


import java.util.ArrayDeque;
import java.util.Deque;

public class Deque_example {

    public static void main(String[] args) {

        Deque<Integer>deque = new ArrayDeque<>();

        deque.addFirst(3);
        deque.addFirst(5);
        deque.addLast(7);
        deque.addFirst(1);
        deque.addLast(8);

        System.out.println(deque);

        /*

        аналогично
         - removeFirst / removeLast
         - pollFirst / pollLast;
         - getFirst / getLast
         - peekFirst / peekLast

         */


    }

}
