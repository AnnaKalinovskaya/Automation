package patterns.abstractfactory;

public class MacOsWindow implements UIElement{
    @Override
    public void showElement() {
        System.out.println("Mac OS window displayed");
    }
}
