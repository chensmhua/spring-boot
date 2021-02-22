package service.thead.self;


import service.thead.util.WebDownloader;

import java.io.IOException;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test$
 * @ClassName: ExtendThreadDownloaderPicture$
 * @date ：Created in 2020-07-13 17:53
 * @description：多线程实现下载图片
 * @modified By：
 * @version: 1.01
 */
public class ExtendThreadDownloaderPicture extends Thread{

    private String url;
    private String name;

    public ExtendThreadDownloaderPicture(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run(){
        WebDownloader downloader = new WebDownloader();
        try {
            downloader.downloader(url,name);
            System.out.println("文件下载："+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExtendThreadDownloaderPicture t1 = new ExtendThreadDownloaderPicture("http://t9.baidu.com/it/u=782924706,390182678&fm=193","t1图片");
        ExtendThreadDownloaderPicture t2 = new ExtendThreadDownloaderPicture("http://t9.baidu.com/it/u=782924706,390182678&fm=193","t2图片");
        ExtendThreadDownloaderPicture t3 = new ExtendThreadDownloaderPicture("http://t9.baidu.com/it/u=782924706,390182678&fm=193","t3图片");

        t1.start();
        t2.start();
        t3.start();
    }


}