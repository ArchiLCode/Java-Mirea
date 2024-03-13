package practice6.abstract_factory;

public class DeveloperFactory implements Factory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }
}