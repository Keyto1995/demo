package top.keyto.demo.dubbo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.keyto.demo.dubbo.configuration.ProviderConfiguration;

import java.util.concurrent.CountDownLatch;

/**
 * @author Keyto
 * Created on 2019/10/27
 */
public class AnnotationProviderBootstrap {
    public static void main(String[] args) throws Exception {
        new EmbeddedZooKeeper(2181, false).start();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();

        System.out.println("dubbo service started.");
        new CountDownLatch(1).await();
    }
}
