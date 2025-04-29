package patterns.abstractfactory;

public class Main {
    public static void main(String[] args) {
        Chair myChair = new ModernFactory().createChair();
        Table myTable = new ModernFactory().createTable();

        new MacOsFactory().createButton().showElement();
        new MacOsFactory().createMenu().showElement();
        new MacOsFactory().createWindow().showElement();

        new WindowsFactory().createButton().showElement();
        new WindowsFactory().createWindow().showElement();


    }

}
