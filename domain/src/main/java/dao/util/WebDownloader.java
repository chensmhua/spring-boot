package dao.util;

import java.io.IOException;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.dao.util$
 * @ClassName: WebDownloader$
 * @date ：Created in 2020-07-13 17:40
 * @description：下载器
 * @modified By：
 * @version: 1.01
 */
public class WebDownloader {

    public void downloader(String name,String url) throws IOException {
        FileUtils.download(url,name);
    }
}