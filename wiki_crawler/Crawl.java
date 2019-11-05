package crawl;

import java.io.FileOutputStream;
import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author akshay
 * @version 1.2
 * @since 4/3/2017
 */

public class Crawl {

    static final int LIMIT = 50;
    static final String ROOT = "";
    static long totSize = 0;

    static void p(Object a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        try {

            // <-- proxification part -->
//        System.setProperty("java.net.useSystemProxies", "true");
//        Authenticator.setDefault(new ProxyAuthenticator("063.11627073","jaigopalji"));
//        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
            // <-- Initialisation part -->
            List<String> downloaded = new ArrayList<>();
            List<String> linksList = new ArrayList<>();
            linksList.add("https://en.wikipedia.org/wiki/Gradient_descent");
            Document doc;
            FileOutputStream f;
            String tempLink, tempName;
            Elements links;

            // <- The actual loop -->
            for (int i = 0; i < LIMIT && !linksList.isEmpty(); ++i) {
                doc = Jsoup.connect(linksList.remove(0)).get();
                links = doc.select("a[href][title]");

                // <-- Outputting to File Part -->
                doc.title(doc.title().replace(" - Wikipedia", ""));
                f = new FileOutputStream(ROOT + doc.title() + ".html");
                f.write(doc.toString().getBytes());
                f.close();

                // <-- To save Mobile Data ;) -->
                p((i + 1) + ". " + doc.title());
                downloaded.add(doc.title());
                totSize += doc.toString().length();

                //  <-- Adding to candidates for download -->
                for (int j = 0; j < links.size(); ++j) {
                    if (downloaded.contains(links.get(j).text())) {
                        p("Already Downloaded -- " + links.get(j).text());
                    } else {
                        tempLink = links.get(j).attr("abs:href");
                        if (!tempLink.contains("%") && tempLink.startsWith("https://en.wikipedia.org/wiki/")) {
                            linksList.add(tempLink);
                        }
                    }
                }

//        links.stream().forEach((link) -> {
//            p(link.attr("abs:href")+ "--" +link.text());
//        });
            }
        } catch (Exception e) {
            p(e.getMessage());
        }

        p("\nTotal Size Downloaded :" + (totSize/1024) +"KB");
    }
}
