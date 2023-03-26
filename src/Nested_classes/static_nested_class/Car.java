package Nested_classes.static_nested_class;


/*

внутренний класс будет статическим элементом внутри внешнего класса.
вложенные классы нужны когда мы хотим привязать один класс к другому /
сделать его элементом внешнего класса

 - может содержать static и non static элементы
 - может обращаться даже к private элементам внешнего класcа, но только к static
 - также и внешний по отношению к внутреннему

 внутри класса можно создать интерфейс

 */

public class Car {

    String color;
    int doorCount;
    Engine engine;

    private static int a;


    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
        System.out.println(a);
    }


    @Override
    public String toString() {
        return "Me Car -> {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public static class Engine{

        int hoursePower;

        public Engine(int hoursePower) {
            this.hoursePower = hoursePower;
        }

        @Override
        public String toString() {
            return "My Engine -> {" +
                    "hoursePower=" + hoursePower +
                    '}';
        }
    }


}


class Test{

    public static void main(String[] args) {

        /*

        статичный вложенный класс можно использовать как обычный внешний класс
        достаточно указать в каком классе он лежит

         */

        Car.Engine engine = new Car.Engine(250);
        System.out.println(engine);

        Car car = new Car("Red", 2, engine);


    }


}
