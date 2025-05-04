package urlservice;

public class Main {

    public static void main (String[] args){
        UrlShortenerService myService = new UrlShortenerService(new Base64StrategyFactory().createStrategy(), URLStorageMap.getInstance());
        String shortUrl = myService.shortenUrl("https://veryyyyyveryyylong/url/super/long");
        System.out.println(shortUrl);
        System.out.println(myService.getOriginalUrl(shortUrl));

    }
}
