package patterns.factorymethod;

 class BowFactory implements WeaponFactory{

     public Weapon createWeapon(){
         return new Bow();
     }
}
