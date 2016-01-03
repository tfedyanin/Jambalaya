package composite;

/**
 * tim on 2015.
 * Интерфейс для составных компонентов. Позволяет формировать и менять сложные компоненты.
 */
public interface Composite {
    /**
     *
     * @param component простой или сложный компонент
     */
    void add(Component component);

    /**
     *
     * @param component простой или сложный компонент
     */
    void remove(Component component);
}
