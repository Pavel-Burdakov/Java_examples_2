package Nested_classes.local_inner_class;


/*
по аналогии с локальной переменной локальный класс не может быть static
виден только в методе в котором он создавался
в нашем случае getResult
*  на практике редки, но повышают инкапсуляцию
*  может обращаться даже к private элементам внешнего класса;
*  может обращаться к переменным метода в котором создается, но только если они
final или final по сути (то есть ее значение по факту нигде не меняется)

 */



public class LocalInner_example1  {

    public static void main(String[] args) {
        Math math = new Math();
        math.getResult();;
    }

}


class Math{
    public void getResult(){

        class  delenie{

            private int delimoe;
            private int delitel;

            public int getDelimoe() {
                return delimoe;
            }

            public int getDelitel() {
                return delitel;
            }

            public void setDelimoe(int delimoe) {
                this.delimoe = delimoe;
            }

            public void setDelitel(int delitel) {
                this.delitel = delitel;
            }

            public int getChastnoe(){
                return delimoe/delitel;
            }

            public int getOstatok(){
                return delimoe%delitel;
            }


        }

        delenie delenie1= new delenie();
        delenie1.setDelimoe(21);;
        delenie1.setDelitel(4);

        System.out.println(delenie1.getDelimoe());
        System.out.println(delenie1.getDelitel());
        System.out.println( delenie1.getChastnoe() );
        System.out.println(delenie1.getOstatok());

    }
}
