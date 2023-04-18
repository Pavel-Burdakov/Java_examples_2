package Stream;

import java.util.Arrays;

public class methodChainingExample {

    public static void main(String[] args) {

        int [] arr = {3,4,1,8,7,4,9,6,0,1,4,5,2,};
    /*    arr = Arrays.stream(arr).sorted().toArray();
        System.out.println(arr);*/

        int res = Arrays.stream(arr).filter(e-> e%2==1)
                .map(e->{if (e%3==0){e=e/3;}return e;})
                .reduce((a, e)->a+e).getAsInt();





    }

}
