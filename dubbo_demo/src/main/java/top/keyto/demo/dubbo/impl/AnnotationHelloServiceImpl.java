package top.keyto.demo.dubbo.impl;

import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import top.keyto.demo.dubbo.AnnotationConstants;
import top.keyto.demo.dubbo.api.HelloService;

/**
 * @author Keyto
 * Created on 2019/10/27
 */
@Service(version = AnnotationConstants.VERSION, methods = {@Method(name = "sayGoodbye", timeout = 250, retries = 0)})
public class AnnotationHelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("provider received invoke of sayHello: " + name);
        sleepWhile();
        return "Annotation, hello " + name;
    }

    public String sayGoodbye(String name) {
        System.out.println("provider received invoke of sayGoodbye: " + name);
        sleepWhile();
        return "Goodbye, " + name;
    }

    private void sleepWhile() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
