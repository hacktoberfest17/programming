package crawl;

import java.io.FileOutputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * @author akshay
 * @version 1.2
 * @since 4/3/2017
 */

public class StaticCrawl {
    
    static void p(Object a){ System.out.println(a); }
    public static void main(String[] args) {try{

        
//        // <-- proxification part -->
//        System.setProperty("java.net.useSystemProxies", "true");
//        Authenticator.setDefault(new ProxyAuthenticator("063.11627073","jaigopalji"));
//        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
        
        
        // <-- Initialisation part -->
        Document doc = Jsoup.connect("http://localhost/c.html").get();
        Elements links = doc.select("a[href][data-click-label]");        
        FileOutputStream f  = new FileOutputStream("/home/akshay/c.txt");
        
        for(Element link:links)
            if (!link.attr("data-click-label").contains("Home")) 
                f.write((link.attr("data-click-label")+"\n").getBytes());
        
        f.close();
        
    }catch(Exception e){p(e.getMessage());}
    }    
}
