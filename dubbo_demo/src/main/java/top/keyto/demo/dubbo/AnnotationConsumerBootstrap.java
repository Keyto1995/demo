package top.keyto.demo.dubbo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.keyto.demo.dubbo.action.AnnotationAction;
import top.keyto.demo.dubbo.configuration.ConsumerConfiguration;

/**
 * @author Keyto
 * Created on 2019/10/27
 */
public class AnnotationConsumerBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");

        System.out.println("hello : " + annotationAction.doSayHello("world"));
        System.out.println("goodbye : " + annotationAction.doSayGoodbye("world"));
        System.out.println("greeting : " + annotationAction.doGreeting("world"));
        System.out.println("reply : " + annotationAction.replyGreeting("world"));
    }
}
