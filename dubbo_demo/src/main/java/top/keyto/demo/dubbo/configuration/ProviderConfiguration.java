package top.keyto.demo.dubbo.configuration;

import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Keyto
 * Created on 2019/10/27
 */
@Configuration
@EnableDubbo(scanBasePackages = "top.keyto.demo.dubbo.impl")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ProviderConfiguration  {

    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(3000);
        return providerConfig;
    }
}
