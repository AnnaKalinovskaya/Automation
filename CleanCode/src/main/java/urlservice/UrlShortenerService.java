package urlservice;

 class UrlShortenerService {

     private URLStorage storage;
     private Strategy strategy;

     public UrlShortenerService(Strategy strategy, URLStorage storage){
         this.storage = storage;
         this.strategy = strategy;
     }

     public String shortenUrl (String originalUrl){
         String shortUrl = this.strategy.shorten(originalUrl);
         this.storage.store(shortUrl, originalUrl);
         return shortUrl;
     }

     public String getOriginalUrl (String shortUrl){
         return this.storage.getOriginalUrl(shortUrl);
     }
}
