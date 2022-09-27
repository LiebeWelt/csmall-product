package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class AttributeTemplateMapperTests {

    @Autowired
    AttributeTemplateMapper mapper;

    @Test
    void testInsert() {
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setName("测试相册001");
        attributeTemplate.setPinyin("测试简介001");
        attributeTemplate.setKeywords("测试简介001");
        attributeTemplate.setSort(99); // 注意：取值必须是 [0, 255]

        int rows = mapper.insert(attributeTemplate);
        System.out.println("插入数据完成，受影响的行数=" + rows);
    }

    @Test
    void testInsertBatch() {
        List<AttributeTemplate> attributeTemplateList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            AttributeTemplate attributeTemplate = new AttributeTemplate();
            attributeTemplate.setName("批量插入的测试名称" + i);
            attributeTemplate.setPinyin("批量插入的测试拼音" + i);
            attributeTemplate.setKeywords("批量插入的测试关键字" + i);
            attributeTemplate.setSort(66);
            attributeTemplateList.add(attributeTemplate);
        }

        int rows = mapper.insertBatch(attributeTemplateList);
        System.out.println("批量插入数据完成，受影响的行数=" + rows);
    }

    @Test
    void testDeleteByID(){
        Long id = new Long(1);
        int rows = mapper.deleteById(id);
        System.out.println("删除完成，受影响的行数=" + rows);
    }

    @Test
    public void testDeleteByIds() {
        Long[] ids = {2L, 3L};
        int rows = mapper.deleteByIds(ids);
        log.info("批量删除完成，受影响的行数={}", rows);
    }


    @Test
    void testUpdateById() {
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setId(8L);
        attributeTemplate.setName("真的很新的名称");
        attributeTemplate.setPinyin("真的很新的拼音");
        attributeTemplate.setKeywords("真的很新的关键字");
        attributeTemplate.setSort(166);

        int rows = mapper.updateById(attributeTemplate);
        System.out.println("修改数据完成，受影响的行数=" + rows);

    }
    
    @Test
    void testCount(){
        int count = mapper.count();
        System.out.println("统计完成，数量=" + count);
    }

    @Test
    public void testCountByName() {
        String name = "测试相册001";
        int count = mapper.countByName(name);
        log.debug("根据名称【{}】统计模板数量完成，统计结果={}", name, count);
    }

    @Test
    void testGetStandardById() {
        Long id = 9L;
        Object result = mapper.getStandardById(id);
        System.out.println("根据id=" + id + "查询标准信息完成，结果=" + result);
    }

    @Test
    void testList() {
        List<?> list = mapper.list();
        System.out.println("查询列表完成，列表中的数据的数量=" + list.size());
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
