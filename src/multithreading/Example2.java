package multithreading;

/*
* более популярный вариант создание потока
* с помощью имплементации интерфейса
* */

public class Example2 {

    public static void main(String[] args) {

        // потоки создаются в таком варианте так
        // в конструктор экземпляра потока передается
        // экземпляр класса который имплементировал Runnable
        Thread thread3 = new Thread(new MyThread3());
        Thread thread4 = new Thread(new MyThread4());

        // аналогично непредсказуемый вывод, кто в какой-то момент
        // захватит консоль
        thread3.start();
        thread4.start();

        // созданием потока с помощью анонимного класса,
        // который имплементирует runnable

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("поток c с помощью анонимного класса ");
            }
        }).start();

        // можно с помощью лямбды, т.к. ruunable имеет один метод,
        // то есть он функциональный

        new Thread(()-> System.out.println("поток c с помощью лямбды"))
                .start();



    }

}


class MyThread3 implements Runnable{
    // в этот метод закладывается логика, что должен делать поток
    // override
    public void run(){
        for (int i = 1; i<1000; i++){
            System.out.println(i);
        }
    }
}

class MyThread4 implements Runnable{
    // в этот метод закладывается логика, что должен делать поток
    // override
    public void run(){
        for (int i = 1; i<1000; i++){
            System.out.println(i);
        }
    }
}
