package multithreading;

public class joinExample {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main begins");
        Thread thread = new Thread(new Worker());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());

        //ждать пока thread не завершит свою работу,
        // но не дольше 1.5 секунды
        thread.join(1500);
        System.out.println(thread.getState());
        System.out.println("main ends");

    }


}


class Worker implements Runnable{
    @Override
    public void run() {

        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work ends");


    }
}


