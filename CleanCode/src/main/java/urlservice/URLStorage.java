package urlservice;

public interface URLStorage {

     void store (String shortUrl, String originalUrl);

     String getOriginalUrl(String shortUrl);



}
