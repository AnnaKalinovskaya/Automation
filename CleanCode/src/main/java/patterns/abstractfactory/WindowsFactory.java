package patterns.abstractfactory;

 class WindowsFactory implements ElementFactory{

    @Override
    public UIElement createWindow() {
        return new WindowsWindow();
    }

    @Override
    public UIElement createButton() {
        return new WindowsButton();
    }

    @Override
    public UIElement createMenu() {
        return new WindowsMenu();
    }
}
