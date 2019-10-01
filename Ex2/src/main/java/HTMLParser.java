import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Class đọc dữ liệu HTML từ url
 */
public class HTMLParser {
    private String url;

    /* Constructor */
    public HTMLParser(String url) {
        this.url = url;
    }

    public String getHTML() {
        Connection conn = Jsoup.connect(url);
        String html = "";

        try {
            Document doc = conn.get();
            html = doc.html();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return html;
    }
}
