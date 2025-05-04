package urlservice;

import org.apache.commons.codec.binary.Base64;

class Base64Strategy implements Strategy{

     @Override
     public String shorten(String url) {
         return "short.url/" + new String(Base64.encodeBase64(url.getBytes()));
     }
 }
