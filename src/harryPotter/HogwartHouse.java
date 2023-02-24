package harryPotter;

public class HogwartHouse {
    private int id;
    private String name;
    private int counter;

    public HogwartHouse(int id, String name, int counter) {
        this.id = id;
        this.name = name;
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter += counter;
    }
}
