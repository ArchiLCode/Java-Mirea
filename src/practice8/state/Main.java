package practice8.state;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new StateA());
        context.handle(); // Output: State A

        context.setState(new StateB());
        context.handle(); // Output: State B

        context.setState(new StateC());
        context.handle(); // Output: State C
    }
}