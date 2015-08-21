package org.storm.uset.http;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class HttpUtil {
	
    /**
     * 返回 流
     * @return
     */
    public static InputStream getInputStream(String urlpath) {
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
 
        try {
            URL url = new URL(urlpath);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            // 设置连接网络的超时时间
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
 
            int responseCode = httpURLConnection.getResponseCode();
          
            if (responseCode == 200) {
                inputStream = httpURLConnection.getInputStream();
            }else{
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return inputStream;
    }
    
    
    /**
     *  保存文件到磁盘
     * @param url
     */
    public static void saveToDisk(String url) {
        // 获取输入流
        InputStream inputStream = getInputStream(url);
 
        byte[] date = new byte[1024];
        int len = 0;
        FileOutputStream fileOutputStream = null;
 
        try {
            fileOutputStream = new FileOutputStream("F://example.jpg");
 
            while ((len = inputStream.read(date)) != -1) {
                fileOutputStream.write(date, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
 
        }
 
    }
}
