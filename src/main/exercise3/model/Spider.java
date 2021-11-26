package exercise3.model;

public class Spider extends Animal {

    public Spider() {
        super(8);
    }

    @Override
    public void eat() {
        System.out.println("Spider is eating now...");
    }

    @Override
    public String toString() {
        return "Spider{}";
    }
}
