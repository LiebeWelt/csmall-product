package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AlbumServiceTests {

    @Autowired
    IAlbumService service;

    @Test
    void contextLoad(){
        System.out.println(service);
    }

    @Test
    void testAddNew(){
        AlbumAddNewDTO albumAddNewDTO = new AlbumAddNewDTO();
        albumAddNewDTO.setName("测试相册名称003");
        albumAddNewDTO.setDescription("测试相册简介003");
        albumAddNewDTO.setSort(88);

        try {
            service.addNew(albumAddNewDTO);
            System.out.println("添加相册成功！");
        } catch (RuntimeException e) {
            System.out.println("添加相册失败，相册名称已经被占用！");
        }
    }

    @Test
    void testDelete() {
        Long id = 14L;

        try {
            service.delete(id);
            System.out.println("删除相册成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testList() {
        List<?> list = service.list();
        System.out.println("查询列表完成,列表中的数据的数量="+list.size());
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
