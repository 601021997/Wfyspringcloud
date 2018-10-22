package com.eureka.server.eurekaserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.DoubleSupplier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaServerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void demo(){
        () -> 2
    }

}
