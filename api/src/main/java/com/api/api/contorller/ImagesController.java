package com.api.api.contorller;

import com.api.api.Utils.SocketUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wufangyu
 */
@Controller
@RequestMapping("/image")
public class ImagesController {



    @GetMapping("/getI")
    public String getS(HttpServletResponse response){
        String s = SocketUtils.socketServer(response);
        System.out.println(s);
        return  s;
    }

}
