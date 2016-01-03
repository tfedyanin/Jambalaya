package generating.abstractfactory;

/**
 * tim on 2015.
 */
public class RusFactory implements AbstractFactory {
    private static AbstractFactory instance;

    private RusFactory() {
    }

    @Override
    public Help getHelp() {
        return new RusHelpImpl();
    }

    @Override
    public Images getImages() {
        return new RusImagesImpl();
    }

    @Override
    public Locale getLocale() {
        return new RulLocaleImpl();
    }

    public static AbstractFactory getInstance() {
        if (instance == null) {
            instance = new RusFactory();
        }
        return instance;
    }
}
