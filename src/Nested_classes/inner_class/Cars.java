package Nested_classes.inner_class;

/*

создание вложенного класса происходит во внешнем

 */

public class Cars {

    String color;
    int doorCount;
    My_Engine engine;


    public Cars(String color, int doorCount, int hoursePower) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = this.new My_Engine(hoursePower);

    }

    public Cars(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
    }


    public void setEngine(My_Engine engine){

        this.engine = engine;

    }


    @Override
    public String toString() {
        return "Me Car -> {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public class My_Engine {

        int hoursePower;

        public My_Engine(int hoursePower) {
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
