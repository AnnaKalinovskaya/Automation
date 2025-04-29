package patterns.facade;

 class HouseFacade {

    private LightSystem light;
    private SecuritySystem security;
    private Conditioner conditioner;

      HouseFacade(LightSystem light, SecuritySystem security, Conditioner conditioner) {
         this.light = light;
         this.security = security;
         this.conditioner = conditioner;
     }

     protected void turnLight (Boolean value){
          if (value){
              this.light.turnOn();
              System.out.println("Light is on");
          } else {
              this.light.turnOff();
              System.out.println("Light is off");
          }
     }

     protected void turnConditioner (Boolean value) {
         if (value) {
             this.conditioner.turnOn();
             System.out.println("Con is on");
         } else {
             this.conditioner.turnOff();
             System.out.println("Com is off");
         }
     }

         protected void turnSecurity (Boolean value){
             if (value){
                 this.security.turnOn();
                 System.out.println("Alarm is on");
             } else {
                 this.security.turnOff();
                 System.out.println("Alarm is off");
             }
     }

 }
