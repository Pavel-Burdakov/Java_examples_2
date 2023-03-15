package generics.game;

public class Test {

    public static void main(String[] args) {


        Schoolar s1 = new Schoolar("Ivan", 13);
        Schoolar s2 = new Schoolar("Olga", 14);
        Schoolar s3 = new Schoolar("Marina", 13);
        Schoolar s4 = new Schoolar("Oleg", 14);



        Student st1 = new Student("Igor", 20);
        Student st2 = new Student("Kseniya", 18);

        Employee emp1 = new Employee("Zaur", 32);
        Employee emp2= new Employee("Vika", 30);


        Team <Schoolar> schoolarTeaam = new Team("Drakon");
        Team <Schoolar> schoolarTeam2 = new Team<>("Pechenegi");

        Team <Student> studentTeam = new Team<>("Hacker Life");
        Team <Employee> employeeTeam = new Team<>("Chop is Dish");


        schoolarTeaam.addNewParticipant(s1);
        schoolarTeaam.addNewParticipant(s2);
        schoolarTeam2.addNewParticipant(s3);
        schoolarTeam2.addNewParticipant(s4);

        studentTeam.addNewParticipant(st1);
        studentTeam.addNewParticipant(st2);

        employeeTeam.addNewParticipant(emp1);
        employeeTeam.addNewParticipant(emp2);

        schoolarTeaam.playWith(schoolarTeam2);









    }

}
