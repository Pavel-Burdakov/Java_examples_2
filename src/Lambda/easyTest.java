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
        def ((String str)->{return str.length();});

    }


}



interface I{

    int abc (String S);

}
