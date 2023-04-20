package multithreading;

public class synchronizedBlockExample {

    public static void main(String[] args) {
        myRun2 myRun2= new myRun2();

        Thread t1 = new Thread(myRun2);
        Thread t2 = new Thread(myRun2);
        Thread t3 = new Thread(myRun2);

        t1.start();
        t2.start();
        t3.start();



    }

}



class Counter2{
    volatile static int cnt = 0;
}

class myRun2 implements Runnable {

    private void dowork2(){

        System.out.println("Go");

    }

    private void dowork1() {
        // при использовании syn блоков нужно явно указывать монитор
        // какого объекта используется для блокировки
        // если метод не статичный, то синхронизация всегда идет на объекте this

        // главное отличие синхронизированного блока от метода в том, что
        // можно синхронизировать не весь метод, а его часть
        dowork2();
        synchronized (this) {
            Counter2.cnt++;
            System.out.println(Counter2.cnt + " ");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            dowork1();
        }
    }
}