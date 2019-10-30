package top.keyto.demo.dubbo.api;

/**
 * @author Keyto
 * Created on 2019/10/27
 */
public interface HelloService {
    String sayHello(String name);

    default String sayGoodbye(String name) {
        return "Goodbye, " + name;
    }
}
