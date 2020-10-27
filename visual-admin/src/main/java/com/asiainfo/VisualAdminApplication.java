package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author wangjingyuan
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class VisualAdminApplication {

    public static void main(String[] args)
    {

        SpringApplication.run(VisualAdminApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  可视化数据中心启动成功   ლ(´ڡ`ლ)ﾞ  \n" );
    }

}
