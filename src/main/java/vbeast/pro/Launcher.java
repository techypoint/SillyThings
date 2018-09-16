package vbeast.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by varun on 12/9/18.
 */

@SpringBootApplication(scanBasePackages = "vbeast.pro")
@EnableAsync
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class,args);
    }



    @Bean
    public Executor asyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;

    }
}
