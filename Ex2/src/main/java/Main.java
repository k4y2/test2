public class Main {

    public static void main(String[] args) {
        HTMLParser parser = new HTMLParser("http://dantri.com.vn");

        Utils.writeToFile(parser.getHTML());
    }
}
