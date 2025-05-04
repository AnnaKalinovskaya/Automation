package urlservice;

import java.util.HashMap;

class URLStorageMap implements URLStorage{

     private HashMap<String, String> urls = new HashMap<>();

     private static URLStorageMap instance;

     private URLStorageMap(){};

     protected static  URLStorageMap getInstance(){
         if (instance == null){
             instance = new URLStorageMap();
         }
         return instance;
     }

    public void store (String shortUrl, String originalUrl){
        urls.put(shortUrl, originalUrl);
    }

    public String getOriginalUrl(String shortUrl){
         return this.urls.get(shortUrl);
    }
}
