package top.keyto.demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Keyto
 * Created on 2019/10/30
 */
public class SimpleLog {
    private static final Logger log = LoggerFactory.getLogger(SimpleLog.class);

    public static void main(String[] args) {
        int times = 1000_0000;
        if (args.length > 0) {
            times = Integer.parseInt(args[0]);
        }
        int finalTimes = times;

        for (int i = 0; i < 4; i++) {
            new Thread(() -> logToFile(finalTimes)).start();
        }
    }

    static void log() {
        log.error("error: Hello");
        log.warn("warn: Hello");
        log.info("info: Hello");
        log.debug("debug: Hello");
        log.trace("trace: Hello");

        log.info("日志级别：trace < debug < info < warn < error 默认：debug");
    }

    private static void logToFile(int times) {
        for (int i = 0; i < times; i++) {
            log.error("Log error: {}", i);
        }
    }

}
