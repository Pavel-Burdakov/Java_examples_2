package Lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class testSupplier {

    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier){
        ArrayList<Car> carArrayList = new ArrayList<>();
        for (int i = 0; i<3; i++){
            carArrayList.add(carSupplier.get());
        }
        return  carArrayList;
    }

    public static void changeCar(Car car, Consumer<Car> carConsumer){
        carConsumer.accept(car);

    }


    public static void main(String[] args) {

        ArrayList<Car> ourCars = createThreeCars(() ->new Car("Nissan T", "red", 1.6));
        System.out.println("Cars - > " + ourCars);

        changeCar(ourCars.get(0), car -> {car.color = "white"; car.engine = 2.5;});

        System.out.println("_______________________________");
        System.out.println(ourCars.get(0));
        System.out.println("Cars - > " + ourCars);


    }


}




class Car{

    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}