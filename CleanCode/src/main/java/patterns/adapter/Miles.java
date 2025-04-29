package patterns.adapter;

 class Miles {

    private double value;

    protected Miles(double value) {
        this.value = value;
    }

     protected double getValue() {
         return value;
     }
 }
