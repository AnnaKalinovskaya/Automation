package streamingservice;

public class WmvAdapter implements VideoAdapter{
    @Override
    public Video convert(String path) {
        System.out.println("WMV Video is converted to MP4");
        return new Video();
    }
}
