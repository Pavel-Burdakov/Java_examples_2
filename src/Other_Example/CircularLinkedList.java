package Other_Example;


/*
* Задача реализовать кольцевой односвязный список
*  - хранит строки;
*  - может хранить null;
*  - без обобщений (Generics);
*  - не поддерживает многопоточность
*
* */

// класс представляющий собой экземпляр нашего кольцевого односвязного списка
public class CircularLinkedList {

    // внутренний описывает узел
    private static class Node{
        Node next; // ссылка на следующий элемент
        String value; // само значение
        Node head; // возможность хранить ссылку с хвоста в голову если он последний

        public Node(String value) {
            this.value = value;
        }

        public Node(Node next, Node head) {
            this.next = next;
            this.head = head;
        }
    }



}
