package practice7.linker;

    public class Main {
        public static void main(String[] args) {
            Composite composite = new Composite();

            composite.add(new Leaf("Leaf 1"));
            composite.add(new Leaf("Leaf 2"));
            composite.add(new Leaf("Leaf 3"));

            composite.operation();
        }
    }