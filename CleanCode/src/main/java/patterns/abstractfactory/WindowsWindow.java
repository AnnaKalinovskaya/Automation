package patterns.abstractfactory;

public class WindowsWindow implements UIElement{

    @Override
    public void showElement() {
        System.out.println("Windows window displayed");
    }
}
