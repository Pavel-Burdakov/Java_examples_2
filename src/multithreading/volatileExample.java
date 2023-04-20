package multithreading;

public class volatileExample extends Thread{

    /*
    * Ключевое слово volatile
    * говорит о том, что значение переменной будет храниться
    * только в main memory, а не в кэш памяти потоков
    * в таком случае оба потока смогут использовать значение
    * этой переменной.
    *
    * Без указания volatile изменение переменной в одном из потоков
    * неизвестно когда повлечет если вообще это сделает изменение ее
    * значения в другом потоке.
    *
    *
    * Для синхронизации значений переменных между потоками ключевое
    * слово volatile используется тогда, когда только один поток может изменять
    * значение этой переменной, а остальные могут его только читать.
    *
    * */
    volatile boolean b = true;

    @Override
    public void run(){
        long counter = 0;
        while (b){
            counter++;
        }
        System.out.println("Finish, counter = " + counter);

    }


    public static void main(String[] args) throws InterruptedException {

        volatileExample thread = new volatileExample();
        thread.start();

        // засыпает поток main на 3 секунды
        Thread.sleep(3000);
        System.out.println("After 3 sec. ");

        // Изменяем b на false, чтобы выйти из цикла в другом потоке
        // если бы b была не volatile, то поток с циклом продолжал бы использовать
        // закэшированное значение b = true и не вышел бы из цикла
        thread.b = false;

        thread.join();
        System.out.println("finish");


    }


}
