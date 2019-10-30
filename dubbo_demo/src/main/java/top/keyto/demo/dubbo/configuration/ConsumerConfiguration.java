package top.keyto.demo.dubbo.configuration;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Keyto
 * Created on 2019/10/27
 */
@Configuration
@EnableDubbo(scanBasePackages = "top.keyto.demo.dubbo.action")
@PropertySource("classpath:/spring/dubbo-consumer.properties")
@ComponentScan(value = {"top.keyto.demo.dubbo.action"})
public class ConsumerConfiguration {
}
