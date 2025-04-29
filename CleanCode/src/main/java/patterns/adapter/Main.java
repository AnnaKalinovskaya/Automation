package patterns.adapter;

public class Main {
    public static void main (String[] args){
        PDF pdf = new PDF("pdf path");

        new DocumentProcessor().processFile(new DocAdapter(pdf).convert());

        new KmDistance(new KmAdapter(new Miles(5)).convert()).processing();

    }
}
