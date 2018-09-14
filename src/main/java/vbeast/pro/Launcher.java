package vbeast.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by varun on 12/9/18.
 */

@SpringBootApplication(scanBasePackages = "vbeast.pro")
@EnableAsync
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class,args);
    }
}
