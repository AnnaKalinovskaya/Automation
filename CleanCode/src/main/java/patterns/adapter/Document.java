package patterns.adapter;

 abstract class Document {

    private String path;

    protected Document (String path){
        this.path = path;
    }
}
