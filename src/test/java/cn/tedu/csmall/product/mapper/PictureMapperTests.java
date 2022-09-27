package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Picture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PictureMapperTests {

    @Autowired
    PictureMapper mapper;

    @Test
    void testInsert() {
        Picture data = new Picture();
        data.setDescription("测试数据001的描述");

        System.out.println("插入数据之前，参数=" + data);
        int rows = mapper.insert(data);
        System.out.println("插入数据完成，受影响的行数=" + rows);
        System.out.println("插入数据之后，参数=" + data);
    }

    @Test
    void testInsertBatch() {
        List<Picture> list = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            Picture item = new Picture();
            item.setDescription("批量插入的测试数据描述00" + i);
            list.add(item);
        }

        int rows = mapper.insertBatch(list);
        System.out.println("批量插入数据完成，受影响的行数=" + rows);
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        int rows = mapper.deleteById(id);
        System.out.println("删除数据完成，受影响的行数=" + rows);
    }

    @Test
    void testDeleteByIds() {
        Long[] ids = {1L, 3L, 5L, 7L, 9L};
        int rows = mapper.deleteByIds(ids);
        System.out.println("批量删除数据完成，受影响的行数=" + rows);
    }

    @Test
    void testUpdateById() {
        Picture data = new Picture();
        data.setId(1L);
        data.setDescription("新的测试数据描述");

        int rows = mapper.updateById(data);
        System.out.println("修改数据完成，受影响的行数=" + rows);
    }

    @Test
    void testCount() {
        int count = mapper.count();
        System.out.println("统计数据完成，数量=" + count);
    }

    @Test
    void testGetStandardById() {
        Long id = 1L;
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
