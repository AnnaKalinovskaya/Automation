package streamingservice;

public class MovAdapter implements VideoAdapter{
    @Override
    public Video convert(String path) {
        System.out.println("MOV Video is converted to MP4");
        return new Video();
    }
}
