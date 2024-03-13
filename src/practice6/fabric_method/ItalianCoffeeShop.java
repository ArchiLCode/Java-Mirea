package practice6.fabric_method;

public class ItalianCoffeeShop extends CoffeeShop {
    @Override
    protected Coffee createCoffee(String name) {
        Coffee coffee = null;
        if (name == "Americano") {
            coffee = new ItalianStyleAmericano();
        } else if (name == "Cappuccino") {
            coffee = new ItalianStyleCappuccino();
        }
        return coffee;
    }
}
