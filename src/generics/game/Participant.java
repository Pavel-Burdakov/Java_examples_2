package generics.game;

public abstract class Participant {

    private String name;
    private  int agr;

    public Participant(String name, int agr) {
        this.name = name;
        this.agr = agr;
    }

    public String getName() {
        return name;
    }

    public int getAgr() {
        return agr;
    }
}
