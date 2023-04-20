package multithreading;

public class sleepExample extends Thread {

    @Override
    public void run() {
        for (int i = 1; i<=10; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new myRunnable1());
        sleepExample thread2 = new sleepExample();

        thread1.start();
        thread2.start();

        /*
        * join вызван внутри потока main
        * это значит, что поток в котором вызван join будет ждать окончания
        * работы поток на котором вызван joim
        *
        * */
        thread1.join();
        thread2.join();

        System.out.println("finish");








    }

}



class myRunnable1 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i<=10; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " "+i);
        }

    }
}