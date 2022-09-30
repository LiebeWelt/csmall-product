package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/brands")
@Api(tags = "03. 品牌管理模块")
public class BrandController {

    @Autowired
    IBrandService brandService;

    public BrandController() {
        log.info("创建控制器类对象：BrandController");
    }

    //http://localhost:9080/brands/add-new?name=Test001&pinyin=1&logo=1&description=1&keywords=1&sort=1&sales=1&productCount=1&commentCount=1&positiveCommentCount=1&enable=1
    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult addNew(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理【添加品牌】的请求，参数：{}", brandAddNewDTO);
        brandService.addNew(brandAddNewDTO);
        return JsonResult.ok();
    }

    //http://localhost:9080/brands/9527/delete
    @ApiOperation("删除品牌")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【删除品牌】的请求，参数：{}", id);
        brandService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/brands
    @ApiOperation("查询品牌列表")
    @ApiOperationSupport(order = 400)
    @GetMapping("")
    public JsonResult<List<BrandListItemVO>> list() {
        log.debug("开始处理【查询相册列表】的请求……");
        List<BrandListItemVO> list = brandService.list();
        return JsonResult.ok(list);
    }
}
