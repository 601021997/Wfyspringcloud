package com.service.controller;

import com.service.utils.SocketUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wufangyu
 */
@Controller
@RequestMapping("/get")
public class ImagesController {

    @GetMapping("getImages")
    public String getOutputStream(HttpServletResponse response) {

            String ids = "这是一个ID的字符串";
        String s = SocketUtils.socketClient(ids);
        //StringUtils.strip(list.toString(),"[]");
        System.out.println(s);
        System.out.println("传过去的图片ID字符串"+ids+"多少");
        return SocketUtils.socketClient(ids);
    }

    /*private OutputStream getOut(HttpServletResponse response, String path) {
        try {
            File file = new File(path);
            FileInputStream fis;
            fis = new FileInputStream(file);
            long size = file.length();
            byte[] temp = new byte[(int) size];
            fis.read(temp, 0, (int) size);
            fis.close();
            byte[] data = temp;
            response.setContentType("image/png");
            OutputStream out = response.getOutputStream();
            System.out.println("data:" + data.toString() + "out:" + out);
            System.out.println( "out:" + out);
            out.write(data);
            return out;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

}
