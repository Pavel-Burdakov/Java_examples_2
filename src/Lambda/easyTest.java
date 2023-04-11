package Lambda;

public class easyTest {

    // def в параметре использует объект типа I
    // выводим на экран результат метода abc с параметром hallo
    // а что делает этот метод мы пишем в методе main
    // при вызове def
    static void def (I i){
        System.out.println(i.abc("Hallo"));
    }

    public static void main(String[] args) {

        // вызываем def который в параметра имеет I
        // вместо того чтобы создавать класс, оверрайдить метод
        // и т.д., мы как бы прямо при вызове делаем override
        // метода abc


        final int i = 1;
        /*использовать внешние переменные в лямбда выражении можно если они final
        * либо они нигде не изменяются (effectivily final)
        * в теле мжно создавать новые переменные с областью видимости только в рамках
        * люмбды
        *
        * */


        def ((String str)->{return str.length() + i;});

    }


}



interface I{

    int abc (String S);

}
