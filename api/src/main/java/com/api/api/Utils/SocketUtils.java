package com.api.api.Utils;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wufangyu
 */
@SuppressWarnings("Duplicates")
@Slf4j
public class SocketUtils {

    /*@Autowired
    private static HttpServletResponse httpServletResponse;*/

    public static String socketServer(HttpServletResponse response) {
        Socket s  = null;
        DataOutputStream dolt = null;
        try {
            while(true){
            ServerSocket server = new ServerSocket(8888);
            log.info("连接服务端获取IP地址HHAHHA" + server.getInetAddress());
            System.out.println("准备接收一个数据...");
            //阻塞式方法
                s  = server.accept();
                System.out.println("接收了一个数据哈哈哈哈哈哈哈...");
                //读--从客户端读数据
                InputStream in = s.getInputStream();
                byte buf[] = new byte[1024];
                in.read(buf);
                System.out.println("read info: " + new String(buf));
                //写--应答客户端--向他写数据
                OutputStream out = s.getOutputStream();
                dolt = new DataOutputStream(out);
                String serverString = getServerString(response);
                dolt.writeUTF(serverString);
                System.out.println("你好，" + s.getInetAddress().getHostAddress() + "  ,你的信息已收到。" + "获取到的图片流集合:" + serverString);
                return in.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String socketClient(String re) {
        OutputStream os = null;
        DataInputStream din = null;
        try {
            //因为是在自己本机上演示，IP就直接填写本机10.30.7.95的了。
            //这个端口和IP都是服务器端的(自己可以改的)
            Socket s = new Socket("192.168.1.235", 8877);
            //和服务器进行三次握手，若失败则出异常，否则返回和对方通讯的socket
            os = s.getOutputStream();
            //发送数据
            os.write(re.getBytes());
            //接收服务器端的反馈
            InputStream in = s.getInputStream();
            din = new DataInputStream(in);
            System.out.println(din.readUTF());
            return din.readUTF();
        } catch (Exception e) {
            e.printStackTrace();
            return "获取数据失败";
        }
    }

    public static OutputStream getOut(HttpServletResponse response, String path) {
        try {
            File file = new File(path);
            FileInputStream fis;
            fis = new FileInputStream(file);
            response.setContentType("image/*");
            ServletOutputStream out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 100];
            while ((len = fis.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
            System.out.println("out:" + out);
            return out;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getServerString(HttpServletResponse response) {
        String path1 = "E:\\ww.png";
        OutputStream out1 = SocketUtils.getOut(response, path1);
        log.info("out1+out2+out3="+out1.toString());
        //OutputStream[] os = new ObjectOutputStream[1];
        //os[0] = out1;
        List<OutputStream> list = new ArrayList<>();
        list.add(out1);
        log.info("加入集合");
        String strip = StringUtils.strip(list.toString(), "[]");
        String ss = list.toString();
        System.out.println(ss+"sssssssss");
        return strip;
    }

}
