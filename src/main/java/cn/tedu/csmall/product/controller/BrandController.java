package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    IBrandService brandService;

    public BrandController() {
        log.info("创建控制器类对象：BrandController");
    }

    //http://localhost:9080/brands/add-new?name=Test001&name=1&pinyin=1&logo=1&description=1&keywords=1&sort=1&sales=1&productCount=1&commentCount=1&positiveCommentCount=1&enable=1    @RequestMapping("/add-new")
    public JsonResult addNew(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理【添加品牌】的请求，参数：{}", brandAddNewDTO);
        brandService.addNew(brandAddNewDTO);
        return JsonResult.ok();
    }

    //http://localhost:9080/brands/9527/delete
    @RequestMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【删除品牌】的请求，参数：{}", id);
        brandService.delete(id);
        return JsonResult.ok();
    }
}
