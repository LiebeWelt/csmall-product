package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AttributeUpdateInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class AttributeServiceTests {

    @Autowired
    IAttributeService service;

    @Test
    void testAddNew() {
        AttributeAddNewDTO attributeAddNewDTO = new AttributeAddNewDTO();
        attributeAddNewDTO.setTemplateId(15L);
        attributeAddNewDTO.setName("大米手机的颜色属性");

        try {
            service.addNew(attributeAddNewDTO);
            log.debug("添加属性成功！");
        } catch (ServiceException e) {
            log.debug(e.getMessage());
        }
    }

    @Test
    void testDeleteById() {
        try {
            Long id = 1L;
            service.deleteById(id);
            log.debug("根据id={}删除属性成功！");
        } catch (ServiceException e) {
            log.debug(e.getMessage());
        }
    }

    @Test
    void testDeleteById1() {
        try {
            Long id = 1L;
            AttributeUpdateInfoDTO attributeUpdateInfoDTO = new AttributeUpdateInfoDTO();
            attributeUpdateInfoDTO.setSort(66);
            service.updateInfoById(id, attributeUpdateInfoDTO);
            log.debug("修改属性基本资料成功！");
        } catch (ServiceException e) {
            log.debug(e.getMessage());
        }
    }

    @Test
    public void testListByTemplateId() {
        Long templateId = 1L;
        List<?> list = service.listByTemplateId(templateId);
        log.info("查询列表完成，结果集中的数据的数量={}", list.size());
        for (Object item : list) {
            log.info("{}", item);
        }
    }

}
