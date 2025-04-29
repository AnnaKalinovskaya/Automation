package patterns.builder;

 class Character {

    private String health;
    private String magic;
    private String damage;
    private String armor;

    Character(String armor, String damage, String magic, String health) {
         this.armor = armor;
         this.damage = damage;
         this.magic = magic;
         this.health = health;
     }

     Character (Builder builder){
        this.armor = builder.armor;
         this.damage = builder.damage;
         this.magic = builder.magic;
         this.health = builder.health;
     }


     static class Builder{
         private String health;
         private String magic;
         private String damage;
         private String armor;


         Builder setHealth(String health){
             this.health = health;
             return this;
         }

          Builder setArmor(String armor) {
             this.armor = armor;
              return this;
         }

          Builder setMagic(String magic) {
             this.magic = magic;
              return this;
         }

          Builder setDamage(String damage) {
             this.damage = damage;
              return this;
         }

         Character build(){
             return new Character(this);
         }
     }
 }
