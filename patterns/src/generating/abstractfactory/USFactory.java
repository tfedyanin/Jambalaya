package generating.abstractfactory;

/**
 * tim on 2015.
 */
public class USFactory implements AbstractFactory {
    private static AbstractFactory instance;

    private USFactory() {
    }

    @Override
    public Help getHelp() {
        return new USHelpImpl();
    }

    @Override
    public Images getImages() {
        return new USImagesImpl();
    }

    @Override
    public Locale getLocale() {
        return new USLocaleImpl();
    }

    public static AbstractFactory getInstance() {
        if (instance == null) {
            instance = new USFactory();
        }
        return instance;
    }
}
