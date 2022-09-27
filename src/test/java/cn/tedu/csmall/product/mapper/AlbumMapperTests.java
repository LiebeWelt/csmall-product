package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class AlbumMapperTests {

    @Autowired
    AlbumMapper mapper;

    @Test
    void testInsert() {
        Album album = new Album();
        album.setName("测试相册002");
        album.setDescription("测试简介002");
        album.setSort(99); // 注意：取值必须是 [0, 255]

        System.out.println("插入数据前"+album);
        int rows = mapper.insert(album);
        System.out.println("插入数据完成，受影响的行数=" + rows);
        System.out.println("插入数据后"+album);


    }

    @Test
    void testInsertBatch() {
        List<Album> albumList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            Album album = new Album();
            album.setName("批量插入的测试相册名称" + i);
            album.setDescription("批量插入的测试相册简介" + i);
            album.setSort(66);
            albumList.add(album);
        }

        int rows = mapper.insertBatch(albumList);
        System.out.println("批量插入数据完成，受影响的行数=" + rows);
    }

    @Test
    void testDeleteByID(){
        Long id = new Long(2);
        int rows = mapper.deleteById(id);
        System.out.println("删除完成，受影响的行数=" + rows);
    }

    @Test
    public void testDeleteByIds() {
        Long[] ids = {3L, 4L, 5L};
        int rows = mapper.deleteByIds(ids);
        log.info("批量删除完成，受影响的行数={}", rows);
    }

    @Test
    void testUpdateById() {
        Album album = new Album();
        album.setId(7L);
        album.setName("真的很新的相册名称");
        album.setDescription("真的很新的相册简介");
        album.setSort(166);

        int rows = mapper.updateById(album);
        System.out.println("修改数据完成，受影响的行数=" + rows);
    }

    @Test
    void testCount(){
        int count = mapper.count();
        System.out.println("统计完成，数量=" + count);
    }

    @Test
    public void testCountByName() {
        String name = "测试相册002";
        int count = mapper.countByName(name);
        log.debug("根据名称【{}】统计相册数量完成，统计结果={}", name, count);
    }

    @Test
    void testGetStandardById() {
        Long id = 7L;
        AlbumStandardVO result = mapper.getStandardById(id);
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
