package generics;


class Pair<V1, V2>{

    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}

public class ParametrizedClass2 {


    public static void main(String[] args) {

        Pair<String, Integer> pair1 = new Pair<>("Hallo", 10);
        System.out.println(pair1);

        Pair<Integer, Double> pair2 = new Pair<>(20, 10.1);
        System.out.println(pair2);




    }


}
