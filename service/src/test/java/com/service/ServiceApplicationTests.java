package com.service;

import com.service.socket.ChatServer;
import com.service.utils.SocketUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceApplicationTests {



    private void buff2Image(byte[] b, String tagSrc) throws Exception {
        FileOutputStream fout = new FileOutputStream(tagSrc);
        //将字节写入文件
        fout.write(b);
        fout.close();
    }


    private byte[] image2Bytes(String imgSrc) throws Exception {
        FileInputStream fin = new FileInputStream(new File(imgSrc));
        //可能溢出,简单起见就不考虑太多,如果太大就要另外想办法，比如一次传入固定长度byte[]
        byte[] bytes = new byte[fin.available()];
        //将文件内容写入字节数组，提供测试的case
        fin.read(bytes);
        fin.close();
        return bytes;
    }


    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }


    @Test
    public void demo() {
        SocketUtils.socketServer();
    }

    @Test
    public void demo1() {
        String path1 = "E:\\ww.png";
        String path2 = "E:\\qwewq.png";
        OutputStream out1 = SocketUtils.getOut(response, path1);
        OutputStream out2 = SocketUtils.getOut(response, path2);
        List<String> os = new ArrayList<>();
        os.add(out1.toString());
        os.add(out2.toString());
        /*OutputStream[] outputStreams = new OutputStream[2];
        outputStreams[0] = out1;
        outputStreams[1] = out2;*/
        SocketUtils.socketClient(os.toString());
        System.out.println(os.toString());
    }

    @Test
    public void demo2() {
        OutputStream os = null;
        DataInputStream din = null;
        try {
            //因为是在自己本机上演示，IP就直接填写本机10.30.7.95的了。
            //这个端口和IP都是服务器端的(自己可以改的)
            Socket s = new Socket("192.168.1.235", 8888);
            //和服务器进行三次握手，若失败则出异常，否则返回和对方通讯的socket
            os = s.getOutputStream();
            //发送数据
            os.write("hahahhah".getBytes());
            //接收服务器端的反馈
            InputStream in = s.getInputStream();
            din = new DataInputStream(in);
            System.out.println(din.readUTF());
            s.close();
            return;
            //os.close();
            //din.close();
        } catch (Exception e) {
            e.printStackTrace();
            //return "获取数据失败";
        }
    }

    @Test
    public void getPictur() {
        try {
            ChatServer.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo3() {
        SocketUtils.socketClient("去玩儿");
    }

    public void demo4() {

       /* while (true) {
            int size = Integer.parseInt(reader.readLine());
            System.out.println("即将接收的图片大小为： " + size);
            try {
                byte[] buffer = new byte[6000];
                File file = new File(i + ".jpg");
                file.createNewFile();
                InputStream input = socket.getInputStream();
                InputStream mess = new DataInputStream(new BufferedInputStream(input));
                RandomAccessFile recv = new RandomAccessFile(file, "rw");
                int num = mess.read(buffer);
                int RecvSize = 0;
                while (num != -1 && (RecvSize < size))    //这条判断语句没有起到监测接收到的数据量的大小的作用
                {
                    RecvSize += num;
                    recv.write(buffer, 0, num);
                    recv.skipBytes(num);
                    num = mess.read(buffer);
                    System.out.print("test: " + RecvSize);
                }
                recv.close();
                i++;

            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }*/

    }

}
