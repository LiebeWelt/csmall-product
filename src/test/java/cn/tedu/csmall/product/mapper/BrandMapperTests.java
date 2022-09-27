package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class BrandMapperTests {

    @Autowired
    BrandMapper mapper;

    @Test
    void testInsert() {
        Brand brand = new Brand();
        brand.setName("测试品牌123");

        log.debug("插入品牌之前，参数对象={}", brand);
        int rows = mapper.insert(brand);
        log.debug("插入品牌完成，受影响的行数={}", rows);
        log.debug("插入品牌之后，参数对象={}", brand);
    }

    @Test
    void testInsertBatch() {
        List<Brand> brandList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            Brand brand = new Brand();
            brand.setName("批量插入" + i);
            brand.setPinyin("批量插入" + i);
            brand.setLogo("批量插入" + i);
            brand.setDescription("批量插入" + i);
            brand.setKeywords("批量插入" + i);
            brand.setSort(66);
            brand.setSales(66);
            brand.setProductCount(66);
            brand.setCommentCount(66);
            brand.setPositiveCommentCount(66);
            brand.setEnable(66);
            brandList.add(brand);
        }

        int rows = mapper.insertBatch(brandList);
        System.out.println("批量插入数据完成，受影响的行数=" + rows);
    }

    @Test
    void testDeleteByID(){
        Long id = new Long(15);
        int rows = mapper.deleteById(id);
        System.out.println("删除完成，受影响的行数=" + rows);
    }

    @Test
    public void testDeleteByIds() {
        Long[] ids = {23L, 24L, 25L};
        int rows = mapper.deleteByIds(ids);
        log.info("批量删除完成，受影响的行数={}", rows);
    }

    @Test
    void testUpdateById() {
        Brand brand = new Brand();
        brand.setId(16L);
        brand.setName("测试品牌-011");
        brand.setPinyin("ceshipinpai-011");

        int rows = mapper.updateById(brand);
        log.debug("根据id修改品牌完成，受影响的行数={}", rows);
    }

    @Test
    void testCount() {
        int count = mapper.count();
        log.debug("统计品牌的数量完成，品牌的数量={}", count);
    }

    @Test
    void testGetStandardById() {
        Long id = 5L;
        Object result = mapper.getStandardById(id);
        System.out.println("根据id=" + id + "查询标准信息完成，结果=" + result);
    }

    @Test
    void testList() {
        List<?> list = mapper.list();
        log.debug("查询品牌列表，查询结果中的数据的数量：{}", list.size());
        for (Object brand : list) {
            log.debug("{}", brand);
        }
    }
}

