package patterns.facade;

import java.util.concurrent.locks.Lock;

public class Main {

    public static void main (String[] args){
        LightSystem light = new LightSystem();
        SecuritySystem security = new SecuritySystem();
        Conditioner con = new Conditioner();

        HouseFacade facade = new HouseFacade(light, security, con);
        facade.turnConditioner(true);
        facade.turnLight(true);
        facade.turnSecurity(false);
        facade.turnConditioner(false);

    }
}
