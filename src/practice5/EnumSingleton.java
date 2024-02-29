package practice5;

public enum EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance() {
        return INSTANCE;
    }
}