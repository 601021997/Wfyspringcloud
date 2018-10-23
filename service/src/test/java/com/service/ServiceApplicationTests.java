package com.service;

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
       /* try {
            File file = new File("E:\\ww.png");
            FileInputStream fis;
            fis = new FileInputStream(file);
            long size = file.length();
            byte[] temp = new byte[(int) size];
            fis.read(temp, 0, (int) size);
            fis.close();
            byte[] data = temp;
            response.setContentType("image/png");
            OutputStream out = response.getOutputStream();
            System.out.println("data:"+data.toString() + "out:"+out);
            out.write(data);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
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
        String s = SocketUtils.socketServer();
        System.out.println("接收到的集合图片流");
    }

    public void getPictur() {

    }

    public void demo3() {
        /*while (true) {
            Socket ClientSocket;
            ClientSocket = server.accept();    //接受
            reader = new BufferedReader(new InputStreamReader(ClientSocket
                    .getInputStream()));
            writer = new PrintWriter(ClientSocket.getOutputStream());
            //图片路径
            String[] str = new String[3];
            str[0] = "C:/Users/Administrator/Desktop/bloig/3.png";
            str[1] = "C:/Users/Administrator/Desktop/bloig/2.png";
            str[2] = "C:/Users/Administrator/Desktop/bloig/1.png";
            for (int i = 0; i < 3; i++) {
                try {
                    File file = new File(str[i]);
                    FileInputStream input = new FileInputStream(file);
                   //首先发送文件长度
                    System.out.println(file.length());
                    writer.println(file.length());
                    writer.flush();

                    byte[] buffer = new byte[6000];

                    try {
                        int num = input.read(buffer);
                        OutputStream output = ClientSocket.getOutputStream();
                        OutputStream sendStream = new DataOutputStream(new BufferedOutputStream(output));
                        while (num != -1) {
                            sendStream.write(buffer, 0, num);
                            sendStream.flush();
                            num = input.read(buffer);
                        }
                        input.close();
                        sendStream.flush();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }*/

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
