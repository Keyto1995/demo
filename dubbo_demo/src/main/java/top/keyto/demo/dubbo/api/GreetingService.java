package top.keyto.demo.dubbo.api;

import java.util.concurrent.CompletableFuture;

/**
 * @author Keyto
 * Created on 2019/10/27
 */
public interface GreetingService {
    String greeting(String name);

    default String replyGreeting(String name) {
        return "Fine, " + name;
    }

    default CompletableFuture<String> greeting(String name, byte signal) {
        return CompletableFuture.completedFuture(greeting(name));
    }
}
