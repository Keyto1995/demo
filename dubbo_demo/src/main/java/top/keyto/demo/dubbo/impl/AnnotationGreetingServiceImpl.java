package top.keyto.demo.dubbo.impl;

import org.apache.dubbo.config.annotation.Service;
import top.keyto.demo.dubbo.AnnotationConstants;
import top.keyto.demo.dubbo.api.GreetingService;

/**
 * @author Keyto
 * Created on 2019/10/27
 */
@Service(version = AnnotationConstants.VERSION)
public class AnnotationGreetingServiceImpl implements GreetingService {

    @Override
    public String greeting(String name) {
        System.out.println("provider received invoke of greeting: " + name);
        sleepWhile();
        return "Annotation, greeting " + name;
    }

    public String replyGreeting(String name) {
        System.out.println("provider received invoke of replyGreeting: " + name);
        sleepWhile();
        return "Annotation, fine " + name;
    }

    private void sleepWhile() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
