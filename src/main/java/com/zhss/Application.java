package com.zhss;

import com.zhss.eshop.config.DruidDbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Hello world!
 *
 * @author liuheng
 */
@SpringBootApplication
@Import(DruidDbConfig.class)
public class Application {
    public static void main( String[] args ) {
        SpringApplication.run(Application.class);
    }
}
