package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.service.IAlbumService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/albums")
@Api(tags = "01. 相册管理模块")
public class AlbumController{

    @Autowired
    private IAlbumService albumService;

    public AlbumController() {
        log.info("创建控制器：AlbumController");
    }

// http://localhost:9080/albums/add-new?name=TestAlbumName001&description=TestDescription001&sort=77
    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult addNew(AlbumAddNewDTO albumAddNewDTO){
//        try {
        log.debug("开始处理【添加相册】的请求，参数：{}", albumAddNewDTO);
        albumService.addNew(albumAddNewDTO);
        return JsonResult.ok();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
    }

    //http://localhost:9080/albums/9527/delete
    @ApiOperation("删除相册")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【删除相册】的请求，参数：{}", id);
        albumService.delete(id);
        return JsonResult.ok();
    }



}
