package patterns.abstractfactory;

 class ModernFactory implements Factory{

     @Override
     public Table createTable() {
         return new ModernTable();
     }

     public Chair createChair(){
         return new ModernChair();
     }
}
