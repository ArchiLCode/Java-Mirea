package practice6.fabric_method;

public class AmericanCoffeeShop extends CoffeeShop {
    @Override
    protected Coffee createCoffee(String name) {
        Coffee coffee = null;
        if (name == "Americano") {
            coffee = new AmericanStyleAmericano();
        } else if (name == "Cappuccino") {
            coffee = new AmericanStyleCappuccino();
        }
        return coffee;
    }
}
