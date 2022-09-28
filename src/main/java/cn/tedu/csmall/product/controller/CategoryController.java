package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.service.ICategoryService;
import cn.tedu.csmall.product.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    ICategoryService categoryService;

    public CategoryController() {
        log.info("创建控制器类对象：CategoryController");
    }

    //http://localhost:9080/categories/add-new?name=Test001&name=1&parentId=1&depth=1&keywords=1&sort=1&icon=1&enable=1&isParent=1&isDisplay=1    @RequestMapping("/add-new")
    public JsonResult addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理【添加类别】的请求，参数：{}", categoryAddNewDTO);
        categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok();
    }

    //http://localhost:9080/categories/9527/delete
    @RequestMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【删除品牌】的请求，参数：{}", id);
        categoryService.delete(id);
        return JsonResult.ok();
    }
}
