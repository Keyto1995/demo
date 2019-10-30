package top.keyto.demo.dubbo.action;


import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import top.keyto.demo.dubbo.AnnotationConstants;
import top.keyto.demo.dubbo.api.GreetingService;
import top.keyto.demo.dubbo.api.HelloService;

/**
 * @author Keyto
 * Created on 2019/10/27
 */
@Component("annotationAction")
public class AnnotationAction {
    @Reference(interfaceClass = HelloService.class, version = AnnotationConstants.VERSION /*,
            methods = {
                    @Method(
                            name = "sayHello",
                            oninvoke = "notify.oninvoke",
                            onreturn = "notify.onreturn",
                            onthrow = "notify.onthrow")
            }
            */
    )
    private HelloService helloService;

    @Reference(interfaceClass = GreetingService.class,
        version = AnnotationConstants.VERSION,
        timeout = 2000,
        methods = {@Method(name = "greeting", timeout = 3000, retries = 1)})
    private GreetingService greetingService;

    public String doSayHello(String name) {
        try {
            return helloService.sayHello(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }

    public String doSayGoodbye(String name) {
        try {
            return helloService.sayGoodbye(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }

    public String doGreeting(String name) {
        try {
            return greetingService.greeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }

    public String replyGreeting(String name) {
        try {
            return greetingService.replyGreeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }
}
