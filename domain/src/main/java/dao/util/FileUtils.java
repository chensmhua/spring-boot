package dao.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.dao.util$
 * @ClassName: FileUtils$
 * @date ：Created in 2020-07-13 17:47
 * @description：文件下载器
 * @modified By：
 * @version: 1.01
 */
public class FileUtils  {

    public static void download(String fileUrl,String fileName) throws IOException {
        //下载地址
        URL url = new URL(fileUrl);
        //获取链接
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("Content-Type", "application/json");
        //获取输入流
        InputStream inputStream = urlConnection.getInputStream();
        String headerField = urlConnection.getHeaderField("Content-Encoding");
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        OutputStream os = new FileOutputStream(fileName);
        // 开始读取
        while ((len = inputStream.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        inputStream.close();
    }
}