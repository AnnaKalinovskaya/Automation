package streamingservice;

import java.util.LinkedList;
import java.util.List;

class VideoService {

    private AviAdapter aviAdapter;
    private MovAdapter movAdapter;
    private WmvAdapter wmvAdapter;
    private LinkedList<Video> videos = new LinkedList<>();

    VideoService (AviAdapter aviAdapter, MovAdapter movAdapter, WmvAdapter wmvAdapter){
        this.aviAdapter = aviAdapter;
        this.movAdapter = movAdapter;
        this.wmvAdapter = wmvAdapter;
    }

    protected String uploadVideo(String path){
        String[] array = path.split("\\.");
        String videoFormat = array[array.length - 1];
        Video video;
        switch (videoFormat){
            case "avi" : {
               video = this.aviAdapter.convert(path);
                break;
            }
            case "mov" : {
                video = this.movAdapter.convert(path);
                break;
            }
            case "wmv" : {
                video =  this.wmvAdapter.convert(path);
                break;
            }
            case "mp4" : {
                video = new Video();
                break;
            }
            default : throw new IllegalArgumentException("Only avi, mov, wmv, mp4 formats are allowed");
        }
        this.videos.add(video);
        return video.getId();
    }

    protected void streamVideo (String id){
        List<String> videoIds = this.videos.stream().map(Video::getId).toList();
        if (videoIds.contains(id)){
        System.out.println("Streaming video: " + id);
        } else new IllegalArgumentException("Video with such id doesn't exist: " + id);
    }
}
