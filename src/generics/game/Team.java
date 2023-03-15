package generics.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// чтобы не создавать класс Team для каждого вида команд (школьники, студенты и т.д)
// используем generics
// ассоциироваться Team будет с конкретным объектом

// если не указать, что T наследник Participant, то моожно будет использовать
// любые классы, что нарушит логику

public class Team <T extends Participant> {

    private String name;

    // в лист можно будет добавлять только объекты одного класса
    // в каждом конкретном случае T бужет заменяться на тот или иной класс
    private List<T> participantList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    // добавлять можем не любого участника, а только типа T
    public void addNewParticipant(T participant){


        participantList.add(participant);

        // если не указать в сигнатуре класс, что T наследник Participants
        // то компилятор не будет знать, что у participant есть метод
        // getName, в этом случае необходим кастинг


//        System.out.println("In Team " + name + "added new participant "
//                + ((Participant)participant).getName());


        // если мы указали, что T наследник Participants, то проблем с методом нет
        System.out.println("In Team " + name + "added new participant "
                + participant.getName());


    }

    // можем запускать только с объектом того же класса, что и вызвал этот метод
    public void playWith(Team<T> team){

        String winnerName;

        Random random = new Random();
        int i = random.nextInt(2);

        if (i==0){
            winnerName = this.name;
        }
        else{
            winnerName = team.name;
        }

        System.out.println("Winner is " + winnerName);

    }



}
