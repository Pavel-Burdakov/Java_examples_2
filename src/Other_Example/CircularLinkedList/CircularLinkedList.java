package Other_Example.CircularLinkedList;


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

    private int size;

    public int getSize() {
        return size;
    }

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
        size++;


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
    /*
     * задача из трех блоков
     * если удаляем первый - делаем перелинковку последнего со вторым
     * если удаляем промежуточный
     * */


    public boolean remove(String value){
        // если последнего элемента нет, значит и лист пустой, возвращаем false
        if (last==null) return false;
        // вызываем метод удаления первого элемента, если вернул true,
        // то и этот метод завершается true
        if (tryRemoveFirst(value)) return true;

        // если вызовы предыдущих методов завершились false
        // то возвращаем результат перегруженного метода remove
        return remove(last.head, last.head.next, value);



    }

    // после удаления первого нужно делать перелинковку,
    // последний должен ссылаться теперь на второй, который станет первым
    private boolean tryRemoveFirst(String value){
        // проверяем если этот элемент первый, то есть
        // значение совпадает с нодой, которая следующая за последней
        if (last.head.value.equals(value)){
            // Если второго элемента нет, значит last один удаляем его
            if (last.head.next == null) last=null;
                // иначе записываем в последний ссылку на второй
            else last.head = last.head.next;
            size--;
            return true;
        }
        // если условие не выполнилось, значит элемент не первый, возвращаем false

        return false;
    }

    private boolean remove(Node prev, Node cur, String value){
        // если текущей ноды нет, то и удалять нечего, false
        if (cur == null) return false;

        // если нашли ноду, которую нужно удалить
        if (cur.value.equals(value)){
            // проверяем если он НЕ последний, т.е в нем нет ссылки на первый элемент
            if (cur.head == null){
                // тогда предыдущему присваиваем ссылку на следующий элемент от найденного
                prev.next = cur.next;
            } else {
                // иначе если последний, то предыдущему next - null, т.к.
                // он становится последним, и записываем ему в head ссылку на первый
                prev.next = null;
                prev.head = cur.head;
            }
            size--;
            return true;

        }

        return remove(cur, cur.next, value);
    }

    @Override
    public String toString() {

        return "CircularLinkedList{" +
                "last=" + last.value +
                '}';
    }



}
