package org.storm.uset.udp;

import java.io.IOException;  
import java.net.DatagramPacket;  
import java.net.DatagramSocket;  
import java.net.InetAddress;  
import java.net.SocketException;  
import java.net.UnknownHostException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Timer;  
/* 
 *应用场景： 一个学校，每当下课时间到了提供提示下课功能。 
 */  
public class UdpSend  
{  
    public void sendData() throws SocketException, UnknownHostException  
    {  
        DatagramSocket ds = new DatagramSocket();// 创建用来发送数据报包的套接字  
        String str = "1";  
        DatagramPacket dp = new DatagramPacket(str.getBytes(),  
                str.getBytes().length,  
                InetAddress.getByName("255.255.255.255"), 3001);  
        // 构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号  
        try  
        {  
            ds.send(dp);  
        } catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
        ds.close();  
  
    }  
  
    public static void main(String[] args)  
    {  
        Timer timer = new Timer();  
        timer.schedule(new MyTask(), 1000, 1000);  
    }  
  
    static class MyTask extends java.util.TimerTask  
    {  
        @Override  
        public void run()  
        {  
            UdpSend tt = new UdpSend();  
            Date d = new Date();  
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
            String strdate = sdf.format(d);  
            String[] classTime = { "17:08:00", "17:19:00", "17:20:00" };  
            for (int i = 0; i < classTime.length; i++)  
            {  
                if (classTime[i].equals(strdate))  
                {  
                    try  
                    {  
                        tt.sendData();  
                    } catch (SocketException e)  
                    {  
                        e.printStackTrace();  
                    } catch (UnknownHostException e)  
                    {  
                        e.printStackTrace();  
                    }  
                }  
            }  
            

					try {
						tt.sendData();
					} catch (SocketException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        }  
    }  
}  