import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    /**
     * Method lấy thời gian hiện tại
     * @return String - thời gian hiện tại
     */
    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH_mm_ss").format(new Date());
    }

    /**
     * Method ghi nội dung text vào file (tên file là thời gian hiện tại)
     * @param text Nội dung cần ghi vào file
     */
    public static void writeToFile(String text) {
        String filename = getCurrentTimeStamp()+".txt";

        File file = new File(filename);
        try {
            file.createNewFile(); // Tạo file mới nếu nó không tồn tại
            FileWriter fw = new FileWriter(file);

            fw.write(text); // Ghi text vào file

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
