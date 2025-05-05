package streamingservice;

public class Main {

    public static void main (String[] args){
        VideoService videoService = new VideoService(new AviAdapter(), new MovAdapter(), new WmvAdapter());
        String id1 = videoService.uploadVideo("random/path/to/my/video.avi");
        videoService.streamVideo(id1);
        String id2 = videoService.uploadVideo("random/path/to/my/video.mov");
        videoService.streamVideo(id2);
    }
}
