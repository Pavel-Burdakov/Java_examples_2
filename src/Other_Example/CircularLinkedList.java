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

    //-------------------------------------------------------------------
    // внутренний класс описывает узел
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
    //-------------------------------------------------------------------




    /* здесь храним ссылку на последний элемент, чтобы
    каждый раз не итерироваться по всему списку при добавлении элемента
    */

    private Node last;

    //-------------------------------------------------------------------

    // реализуем метод добавления новых элементов
    public void add(String value){

        // если пока в списке элементов нет, то идем в метод создания первого узла
        // иначе в метод добавления нового элемента
        if (last == null)
            setFirst(value);
        else addNew(value);


    }


    // метод устанавливает первый узел который направлен сам на себя

    private void setFirst(String value){

        Node firstNode = new Node (value);
        last = firstNode;
        last.head = firstNode;

    }

    private void addNew(String value){

        Node newNode = new Node(value);
        // записываем ссылку в последнем элементе на новою ноду
        last.next = newNode;
        // в новой ноде прописываем ссылку на первый элемент
        newNode.head = last.head;
        // стираем из того элемента, что был последним ссылку на первый элемент
        last.head = null;
        // и теперь вновь добавленный элемент становится последним
        last = newNode;

    }

    //-------------------------------------------------------------------

    // реализуем методы удаления элементов


    private boolean tryRemoveFirst(String value){

        if (last.head.value.equals(value)){
            if (last.head.next == null) last=null;
            else last.head = last.head.next;
            return true;
        }

        return false;
    }




}
