package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.service.impl.CategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    CategoryServiceImpl service;

    @Test
    public void testListByParentId() {
        Long parentId = 0L;
        List<?> list = service.listByParentId(parentId);
        log.info("查询列表完成，结果集中的数据的数量={}", list.size());
        for (Object item : list) {
            log.info("{}", item);
        }
    }
}
