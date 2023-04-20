package multithreading;


/*
* В случае, когда два или более потоков одновременно работают
* с одной переменной возникает так называемый data race, т.е.
* т.е. каждый поток стремиться выполнить задачу, на выходе получаем
* непредсказуемый результат, зависящий по сути от скорости каждого из потоков
*
*
* Вариантом решения проблемы data race является ключевое слово synchronized
*
* */

public class dataRaceSynMethod {

    public static void main(String[] args) {

        myRun1 run1 = new myRun1();

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run1);
        Thread t3 = new Thread(run1);

        t1.start();
        t2.start();
        t3.start();

    }

}

class Counter{
     volatile static int cnt = 0;
}

class myRun1 implements Runnable{

    public synchronized void inc(){
        Counter.cnt++;
        System.out.print(Counter.cnt + " ");
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++){
           inc();
        }
    }
}