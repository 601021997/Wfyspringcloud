package com.api.api;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }

    @Test
    public void test2() {
        String a = "a";
        String b = "b";
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        String join = StringUtils.join(list, ",");
        System.out.println(join);
    }

    @Test
    public void test3(){
        com.api.api.utils.SocketUtils.socketServer(response);
    }

}
