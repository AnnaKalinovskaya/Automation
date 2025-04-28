package patterns.factorymethod;

public class PistolFactory implements WeaponFactory{

    public Weapon createWeapon(){
        return new Pistol();
    }
}
