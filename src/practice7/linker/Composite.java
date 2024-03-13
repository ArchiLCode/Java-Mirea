package practice7.linker;

import java.util.ArrayList;
import java.util.List;

class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void operation() {
        for (Component component : components) {
            component.operation();
        }
    }
}