package practice6.fabric_method;

public abstract class CoffeeShop {
    public Coffee orderCoffee(String name) {
        Coffee coffee = createCoffee(name);

        coffee.makeCoffee();

        System.out.println("Take your " + coffee.getName() + "!");
        return coffee;
    }

    protected abstract Coffee createCoffee(String name);
}
