package multithreading;

public class methodThreadExample {

    public static void main(String[] args) {

/*        MyThread5 myThread5 = new MyThread5();
        System.out.println("Name of Thread = " + myThread5.getName() +
                "  Priorty = " + myThread5.getPriority());

        MyThread5 myThread6 = new MyThread5();
        System.out.println("Name of Thread = " + myThread6.getName() +
                "  Priorty = " + myThread6.getPriority());


        // переопределение имени и приоритета
        myThread5.setName("potok_name");
        myThread5.setPriority(10);
        System.out.println("Name of Thread = " + myThread5.getName() +
                "  Priorty = " + myThread5.getPriority());


        // вместо чисел можно использовать

        myThread5.setPriority(Thread.MIN_PRIORITY); //1
        myThread5.setPriority(Thread.MAX_PRIORITY); //10
        myThread5.setPriority(Thread.NORM_PRIORITY); //5*/

        System.out.println("-------------");


        Thread thread_example = new Thread(new MyThread6());
        thread_example.start();

        System.out.println("Main Thread name = " + Thread.currentThread().getName());

        // делать .run нельзя иначе поток будет частью потока main
        // т.е новый поток не создается
        // нужно делать через .start()

    }

    // приоритетная шкала от 1-10
    // приоритет можно менять, но гарантии, что поток с высшим приоритетом
    // запустится раньше нет







}

class MyThread5 extends Thread{

    public void run(){

        System.out.println("GO "); // покажет в каком потоке мы сейчас находимся

    }

}

class MyThread6 extends Thread{

    public void run(){

        System.out.println("Method RUN. Thread name = " +
                Thread.currentThread().getName()); // покажет в каком потоке мы сейчас находимся

    }

}