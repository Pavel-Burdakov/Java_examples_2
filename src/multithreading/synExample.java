package multithreading;


/*
* Ключевое слово Synchronized перед методом,
* который вызывается в потоке, означает следующее
* как только один из потоков начал пользоваться переменной
* на переменную "вешается замок", т.е. другие потоки
* не могут ее использовать пока первый поток не закончит работу
*
* после чего переменной пользуется другой поток либо снова этот же
* зависит от приоритета и кто знает еще от чего
*
* т.е. в один и тот же момент времени с переменной уже не будут работать
* несколько потоков
*
* Ключевое слово Synchronized может применяться как к статическим так
* и не статическим методам
*
* при этом блокируется именно элемент/объект класса
* блокировка происходит за счет статуса в мониторе
* элемента / объекта класса
*
* у методов мониторов нет, для синхронизации методов используется
* именно монитор объектов/элементов.
*
* Монитор - это сущность/механизм, благодаря которому достигается
* корректная работа при синхронизации.
* В Java у каждого объекта / класса есть привязанный к нему монитор
*
*
* */

public class synExample {
    static int counter = 0;
    public static synchronized void inc(){counter++;}

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new R());
        Thread t2 = new Thread(new R());

        t1.start();
        t2.start();

        // main дожидается завершения работы потоков
        t1.join();
        t2.join();

        System.out.println(counter);

    }


}

class R implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<1000000;i++){
            synExample.inc();
        }

    }
}

