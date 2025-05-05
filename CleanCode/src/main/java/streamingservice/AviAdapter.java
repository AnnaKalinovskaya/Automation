package streamingservice;

public class AviAdapter implements VideoAdapter{
    @Override
    public Video convert(String path) {
        System.out.println("AVI Video is converted to MP4");
        return new Video();
    }
}
