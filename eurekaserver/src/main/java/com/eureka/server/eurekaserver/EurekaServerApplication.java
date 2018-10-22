package com.eureka.server.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

/**
 * @author admin
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
       /* Scanner scanner = new Scanner(System.in);
        String profile =  scanner.nextLine();
        new SpringApplicationBuilder(EurekaServerApplication.class).profiles(profile).run(args);*/
    }
}
