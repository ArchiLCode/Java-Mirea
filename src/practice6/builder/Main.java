package practice6.builder;

public class Main {
    public static void main(String[] args) {
        CarBuilder builder = new ModernCarBuilder();
        AutoEngineer engineer = new AutoEngineer(builder);
        Car car = engineer.manufactureCar();
        if (car != null) {
            System.out.println("Below car delievered: ");
            System.out.println("======================================================================");
            System.out.println(car);
            System.out.println("======================================================================");
        }
    }
}
