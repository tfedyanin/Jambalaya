package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * tim on 2015.
 * Реализация составного компонента
 */
public class CompositeLeaf implements Component, Composite{

    //Collection of child components.
    private List<Component> child = new ArrayList<>();

    @Override
    public void operation() {
        child.forEach(Component::operation);
    }

    @Override
    public void add(Component component) {
        child.add(component);
    }

    @Override
    public void remove(Component component) {
        child.remove(component);
    }
}
