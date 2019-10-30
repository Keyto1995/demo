package top.keyto.demo.logback;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Keyto
 * Created on 2019/10/30
 */
@Slf4j
public class SimpleLogTest {

    @Test
    public void testLog() {
        SimpleLog.log();
    }

}
