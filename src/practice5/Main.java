package practice5;

public class Main {
    public static void main(String[] args) {
        LazyInitializedSingleton test1 = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton test2 = LazyInitializedSingleton.getInstance();
        System.out.println(test1 == test2);

        EnumSingleton test3 = EnumSingleton.INSTANCE;
        EnumSingleton test4 = EnumSingleton.INSTANCE;
        System.out.println(test3 == test4);

        ThreadSafeSingleton test5 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton test6 = ThreadSafeSingleton.getInstance();
        System.out.println(test5 == test6);
    }
}