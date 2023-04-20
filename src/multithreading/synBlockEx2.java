package multithreading;

public class synBlockEx2 {
    static int counter = 0;


    // создание синх блока для статического метода
    // this использовать нельзя, синхронизируемся на самом классе

    public static synchronized void inc(){
        synchronized (synBlockEx2.class) {
            counter++;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new R2());
        Thread t2 = new Thread(new R2());

        t1.start();
        t2.start();

        // main дожидается завершения работы потоков
        t1.join();
        t2.join();

        System.out.println(counter);

    }


}

class R2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<1000000;i++){
            synExample.inc();
        }

    }
}

