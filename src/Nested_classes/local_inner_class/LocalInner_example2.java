package Nested_classes.local_inner_class;

public class LocalInner_example2 {

    public static void main(String[] args) {

        class sum implements Math2{
            @Override
            public int doOperation(int a, int b) {
                return a+b;
            }
        }

        sum s1 = new sum();
        System.out.println(s1.doOperation(5,8));

    }

    interface Math2{

        int doOperation(int a, int b);


    }

}
