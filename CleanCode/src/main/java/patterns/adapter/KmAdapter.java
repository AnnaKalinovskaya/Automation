package patterns.adapter;

 class KmAdapter {

     private Miles miles;

     protected KmAdapter(Miles miles){
         this.miles = miles;
     }

     protected Kilometers convert(){
         return new Kilometers(miles.getValue() * 1.60932);
     }
}
