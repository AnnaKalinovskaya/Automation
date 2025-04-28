package patterns.abstractfactory;

 class ClassicalFactory implements Factory{

     @Override
     public Chair createChair() {
         return new ClassicalChair();
     }

     public Table createTable(){
         return new ClassicalTable();
     }
 }
