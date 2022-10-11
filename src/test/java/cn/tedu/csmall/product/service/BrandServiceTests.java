package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandServiceTests {
    @Autowired
    IBrandService service;

    @Test
    void testSetEnable() {
        Long id = 20L;

        try {
            service.setEnable(id);
            System.out.println("启用品牌成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testSetDisable() {
        Long id = 20L;

        try {
            service.setDisable(id);
            System.out.println("禁用品牌成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
