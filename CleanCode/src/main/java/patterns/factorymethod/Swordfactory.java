package patterns.factorymethod;

class Swordfactory implements WeaponFactory{

    public Weapon createWeapon(){
        return new Sword();
    }
}
