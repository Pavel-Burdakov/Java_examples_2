package Nested_classes.inner_class;

import Nested_classes.static_nested_class.Car;


/*
* каждый объект inner класса всегда жестко ассоциируется с объектом внешнего
* создавая объект inner класса, нужно перед этим создать объект внешнего класса
* inner класс может содержать только non static элементы если они не final
* inner касс может обращаться к private переменным внешнего класса
* аналогично внешний, то прежде создав его объект
*  */

public class inner_class_example {

    // варианты со здания объекта с вложенным классом

    public static void main(String[] args) {

        Cars car = new Cars("Blue", 4, 250);
        System.out.println(car);

        // самый распространенный вариант
        // создается объект внешнего класс, затем с помощью него объект внутреннего класса

        Cars car1 = new Cars("Red", 3);
        System.out.println(car1);

        Cars.My_Engine engine = car1.new My_Engine(500);
        car1.setEngine(engine);
        System.out.println(car1);

        /*
        Объект inner класса жестко привязан к экземпляру объекта супер класса
        поэтому вот так нельзя

        Cars.My_Engine engine1 = new car1.My_Engine(999);

         */


        // данный вариант допустим, но при таком создании экземпляра теряется ссылка
        // на внешний класс, поэтому это не удачный вариант
         Cars.My_Engine engine1 = new Cars("Yellow", 4).new My_Engine(200);






    }

}




