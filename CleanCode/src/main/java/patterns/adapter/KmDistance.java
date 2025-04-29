package patterns.adapter;

 class KmDistance {
    private Kilometers kms;

    protected KmDistance(Kilometers kms){
        this.kms = kms;
    }

    protected void processing (){
        System.out.println("Processing km distance: " + this.kms.getValue());
    }
}
