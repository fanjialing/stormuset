package org.storm.uset.io;

import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
  
public class IoTest {  
    public static void main(String[] args) {  
        File fileSrcFile1 = new File("e:\\新建文件夹.rar");  
        File fileDestFile1 = new File("e:\\demo\\新建文件夹.rar");  
        File fileSrcFileF1 = new File("e:\\复件 新建文件夹.rar");  
        File fileDestFileF1 = new File("e:\\demo\\复件 新建文件夹.rar");  
        try {  
            long start1 = System.currentTimeMillis();  
            copyFile1(fileSrcFile1, fileDestFile1);  
            long end1 = System.currentTimeMillis();  
            System.out.println("copyFile1耗时：" + (end1 - start1) / 1000.0);  
  
            long start2 = System.currentTimeMillis();  
            copyFile2(fileSrcFileF1, fileDestFileF1);  
            long end2 = System.currentTimeMillis();  
            System.out.println("copyFile2耗时：" + (end2 - start2) / 1000.0);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * 把源文件的内容复制到目标文件 
     *  
     * @param src 
     *            源文件 
     * @param dest 
     *            目标文件 
     */  
    public static void copyFile1(File src, File dest) throws IOException {  
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
        byte[] b = new byte[8192];  
        try {  
            bis = new BufferedInputStream(new FileInputStream(src));  
            bos = new BufferedOutputStream(new FileOutputStream(dest));  
  
            for (int count = -1; (count = bis.read(b)) != -1;) {  
                bos.write(b, 0, count);  
            }  
            bos.flush();  
        } catch (IOException e) {  
            throw e;  
        } finally {  
            close(bis);  
            close(bos);  
        }  
    }  
  
    /** 
     * 把源文件的内容复制到目标文件 
     *  
     * @param srcFile 
     *            源文件 
     * @param destFile 
     *            目标文件 
     */  
    public static void copyFile2(File srcFile, File destFile)  
            throws IOException {  
        FileInputStream input = new FileInputStream(srcFile);  
        try {  
            FileOutputStream output = new FileOutputStream(destFile);  
            try {  
                byte[] buffer = new byte[4096];  
                int n = 0;  
                while (-1 != (n = input.read(buffer))) {  
                    output.write(buffer, 0, n);  
                }  
            } finally {  
                try {  
                    if (output != null) {  
                        output.close();  
                    }  
                } catch (IOException ioe) {  
                    // ignore  
                }  
            }  
        } finally {  
            try {  
                if (input != null) {  
                    input.close();  
                }  
            } catch (IOException ioe) {  
                // ignore  
            }  
        }  
    }  
  
    /** 
     * 同时关闭输入流和输出流，并把可能抛出的异常转换成RuntimeException 
     *  
     * @param is 
     * @param os 
     */  
    public static void close(InputStream is, OutputStream os) {  
        close(is);  
        close(os);  
    }  
  
    /** 
     * 关闭输入流的工具方法，并把可能抛出的异常转换成RuntimeException 
     *  
     * @param is 
     */  
    public static void close(InputStream is) {  
        if (is != null) {  
            try {  
                is.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    /** 
     * 关闭输出流的工具方法，并把可能抛出的异常转换成RuntimeException 
     *  
     * @param os 
     */  
    public static void close(OutputStream os) {  
        if (os != null) {  
            try {  
                os.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  
