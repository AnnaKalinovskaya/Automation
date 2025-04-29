package patterns.adapter;

 class Kilometers {
    private double  value;

    protected Kilometers(double value) {
        this.value = value;
    }

     protected double getValue() {
         return value;
     }
 }
