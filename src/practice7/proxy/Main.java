package practice7.proxy;

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");

        image.display();
        System.out.println();
        image.display();
        System.out.println("type 1");
        System.out.println("type 2");
        System.out.println("type 3");
    }
}
