package practice6.fabric_method;

public abstract class Coffee {

    public abstract String getName();

    void makeCoffee() {
        System.out.println("Making " + getName() + " coffee...");
    }
}
