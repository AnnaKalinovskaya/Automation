package patterns.factorymethod;


public class Main {
    public static void main (String[] args){
        Transport bicycle = new BicycleFactory().createTransport();
        Transport car = new CarFactory().createTransport();

        new Swordfactory().createWeapon().shoot();
        new BowFactory().createWeapon().shoot();
    }
}
