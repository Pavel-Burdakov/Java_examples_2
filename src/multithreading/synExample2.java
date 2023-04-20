package multithreading;


/*
*
* синхронизация происходит по объекту,
* в нашем случае все три объекта разные
* поэтому объявление метода как synchronized ничего не даст
*
* в таком случае создается объект и синхронизируются блоки по нему
*
* */

public class synExample2 {

    static final Object lock = new Object();



    synchronized void mobileCall(){

        System.out.println(this);

        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call finish");
        }
    }

    void waCall(){

        System.out.println(this);

        synchronized (lock) {
            System.out.println("WA call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WA call finish");
        }
    }


    void skypeCall(){

        System.out.println(this);

        synchronized (lock) {
            System.out.println("skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("skype call finish");
        }
    }


    public static void main(String[] args) {

        Thread t1=new Thread(new RunnableImpMobile());
        Thread t2=new Thread(new RunnableImpWA());
        Thread t3=new Thread(new RunnableImpSkype());

        t1.start();
        t2.start();
        t3.start();

    }


}


class RunnableImpMobile implements Runnable{
    @Override
    public void run() {
        // метод не статичный
        new synExample2().mobileCall();

    }
}

class RunnableImpWA implements Runnable{
    @Override
    public void run() {
        // метод не статичный
        new synExample2().waCall();

    }
}

class RunnableImpSkype implements Runnable{
    @Override
    public void run() {
        // метод не статичный
        new synExample2().skypeCall();

    }
}


