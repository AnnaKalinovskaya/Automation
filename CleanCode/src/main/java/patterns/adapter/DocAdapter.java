package patterns.adapter;

 class DocAdapter {

    private PDF pdf;

    protected DocAdapter(PDF pdf){
        this.pdf = pdf;
    }

    protected DOC convert(){
        System.out.println("Converting in process...");
        return new DOC("pdf path");
    }
}
