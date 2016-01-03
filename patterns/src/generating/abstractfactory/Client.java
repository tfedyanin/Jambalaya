package generating.abstractfactory;

/**
 * tim on 2015.
 */
public class Client {
    private static void print(AbstractFactory factory) {
        System.out.println("Locale: " + factory.getLocale());
        System.out.println("Images: " + factory.getImages());
        System.out.println("Help: " + factory.getHelp());
    }

    public static void main(String[] args) {
        AbstractFactory factory;
        System.out.println("Russia:");
        print(RusFactory.getInstance());
        System.out.println("US:");
        print(USFactory.getInstance());
    }
}
