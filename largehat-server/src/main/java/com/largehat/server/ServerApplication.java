package com.largehat.server;


import com.largehat.common.im.ImConfig;
import com.largehat.server.config.ImConfiguration;
import com.largehat.server.helper.redis.RedisMessageHelper;
import com.largehat.server.server.ImServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Lion
 * @date 2018/11/15 9:20:19
 */
@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

    @Autowired
    private ImConfiguration configuration ;

    /**
     * <B>启动IM服务器</B>
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ImServer.startServer(configuration);
    }
}
