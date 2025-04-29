package patterns.facade;

 abstract class HouseElement {

    private Boolean isOn;

    protected void turnOn(){
        this.isOn = true;
    }

    protected void turnOff(){
        this.isOn = false;
    }
}
