package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/albums")
public class AlbumController{

    @Autowired
    private IAlbumService albumService;

    public AlbumController() {
        log.info("创建控制器：AlbumController");
    }

// http://localhost:8080/albums/add-new?name=TestAlbumName001&description=TestDescription001&sort=77
    @RequestMapping("/add-new")
    public String addNew(AlbumAddNewDTO albumAddNewDTO){
//        try {
        log.debug("开始处理【添加相册】的请求，参数：{}", albumAddNewDTO);
        albumService.addNew(albumAddNewDTO);
        return "添加相册成功";
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
    }

    // http://localhost:8080/albums/delete?id=1
    @RequestMapping("/delete")
    public String delete(Long id) {
        log.debug("开始处理【删除相册】的请求，参数：{}", id);
        albumService.delete(id);
        return "OK";
    }



}
