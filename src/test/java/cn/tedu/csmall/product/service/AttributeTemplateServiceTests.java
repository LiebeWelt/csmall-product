package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.service.impl.AttributeTemplateServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AttributeTemplateServiceTests {

    @Autowired
    IAttributeTemplateService service;

    @Test
    void contextLoad(){
        System.out.println(service);
    }

    @Test
    void testAddNew(){
        AttributeTemplateAddNewDTO attributeTemplateAddNewDTO = new AttributeTemplateAddNewDTO();
        attributeTemplateAddNewDTO.setName("测试模板002");
        attributeTemplateAddNewDTO.setPinyin("测试模板拼音002");
        attributeTemplateAddNewDTO.setKeywords("测试模板关键字002");
        attributeTemplateAddNewDTO.setSort(88);

        try{
            service.addNew(attributeTemplateAddNewDTO);
            System.out.println("添加模板成功");
        }catch (RuntimeException e){
            System.out.println("添加模板失败,名称已被占用!");
        }
    }

}
