package patterns.abstractfactory;

interface  ElementFactory {

    UIElement createButton();
    UIElement createMenu();
    UIElement createWindow();
}
