package com.service.utils;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;

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

    public static String socketServer() {
        try {
            ServerSocket server = new ServerSocket(8866);
            log.info("连接服务端获取IP地址" + server.getInetAddress());
            System.out.println("准备接收一个数据...");
            //阻塞式方法
            Socket s = server.accept();
            System.out.println("接收了一个数据...");
            //读--从客户端读数据
            InputStream in = s.getInputStream();
            byte buf[] = new byte[1024];
            in.read(buf);
            System.out.println("read info: " + new String(buf));
            //写--应答客户端--向他写数据
            OutputStream out = s.getOutputStream();
            DataOutputStream dout = new DataOutputStream(out);
            dout.writeUTF("你好，" + s.getInetAddress().getHostAddress() + "  ,你的信息已收到。");
            return in.toString();
            // return 之后后调用Finally的方法 可以直接return 关流
           /* dout.close();
            s.close();*/
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
            long size = file.length();
            byte[] temp = new byte[(int) size];
            fis.read(temp, 0, (int) size);
            fis.close();
            byte[] data = temp;
            response.setContentType("image/*");
            OutputStream out = response.getOutputStream();
            System.out.println("data:" + data.toString() + "out:" + out);
            System.out.println("out:" + out);
            out.write(data);
            return out;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getServerString(HttpServletResponse response) {
        String path1 = "E:\\ww.png";
        String path2 = "E:\\qq.png";
        OutputStream out1 = SocketUtils.getOut(response, path1);
        OutputStream out2 = SocketUtils.getOut(response, path2);
        List<OutputStream> os = new ArrayList<>();
        os.add(out1);
        os.add(out2);
        String s = JSONUtils.toJSONString(os);
        SocketUtils.socketClient(s);
        System.out.println(s);
        return s;
    }

}
