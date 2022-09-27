package cn.tedu.csmall.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class Slf4jTests {

    @Test
    void testLog(){
        log.trace("输出了一条【trace】日志……");
        log.debug("输出了一条【debug】日志……");
        log.info("输出了一条【info】日志……");
        log.warn("输出了一条【warn】日志……");
        log.error("输出了一条【error】日志……");
    }
}
