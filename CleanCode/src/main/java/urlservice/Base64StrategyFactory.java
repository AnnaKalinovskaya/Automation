package urlservice;

 class Base64StrategyFactory implements StrategyFactory{

     @Override
     public Strategy createStrategy() {
         return new Base64Strategy();
     }
 }
