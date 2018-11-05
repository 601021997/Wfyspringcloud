package com.service;

import com.service.socket.ChatServer;
import com.service.utils.Base64Util;
import com.service.utils.HttpClient;
import com.service.utils.SocketUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void images() {
        //d:\\source.gif
       String path = "C:\\Users\\wufangyu\\Desktop\\文件\\商品图\\RIO.png";
        byte[] bytes = image2byte(path);
        String encode = Base64Util.encode(bytes);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(encode).append(",").append(encode).append(",").append(encode).append(",").append(encode);
        Map<String,Object> map = new HashMap();
        map.put("typeId","inBox");
        map.put("primaryId","239");
        map.put("changeBeforeImages",stringBuffer.toString());
        map.put("changeAfterImages",stringBuffer.toString());
        //HttpClient.post();
        String post = HttpClient.post("http://taolin.test:9113/pic/updatePicture", map);
        System.out.println(post);
    }


    //图片到byte数组
    public byte[] image2byte(String path) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

}
