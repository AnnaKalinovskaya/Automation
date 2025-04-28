package patterns.abstractfactory;

 class MacOsFactory implements ElementFactory{

    @Override
    public UIElement createButton() {
        return new MacOSButton();
    }

    @Override
    public UIElement createMenu() {
        return new MacOsMenu();
    }

    @Override
    public UIElement createWindow() {
        return new MacOsWindow();
    }
}
