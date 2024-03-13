package practice6.abstract_factory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new DeveloperFactory();

        Developer developer = factory.getDeveloper();
        System.out.println("Coding...");
        developer.writeCode();
    }
}
