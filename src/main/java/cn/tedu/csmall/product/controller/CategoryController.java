package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
import cn.tedu.csmall.product.service.ICategoryService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categories")
@Api(tags = "04. 类别管理模块")
public class CategoryController {
    
    @Autowired
    ICategoryService categoryService;

    public CategoryController() {
        log.info("创建控制器类对象：CategoryController");
    }

    //http://localhost:9080/categories/add-new?name=Test001&parentId=1&depth=1&keywords=1&sort=1&icon=1&enable=1&isParent=1&isDisplay=1
    @ApiOperation("添加类别")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理【添加类别】的请求，参数：{}", categoryAddNewDTO);
        categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok();
    }

    //http://localhost:9080/categories/9527/delete
    @ApiOperation("删除类别")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【删除类别】的请求，参数：{}", id);
        categoryService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/categories
    @ApiOperation("查询类别列表")
    @ApiOperationSupport(order = 400)
    @GetMapping("")
    public JsonResult<List<CategoryListItemVO>> list() {
        log.debug("开始处理【查询相册列表】的请求……");
        List<CategoryListItemVO> list = categoryService.list();
        return JsonResult.ok(list);
    }

    // http://localhost:9080/categories/list-by-parent??parentId=0
    @ApiOperation("根据父级类别查询子级类别列表")
    @ApiOperationSupport(order = 410)
    @ApiImplicitParam(name = "parentId", value = "父级类别id，如果是一级类别，则此参数值应该为0",
            required = true, dataType = "long")
    @GetMapping("/list-by-parent")
    public JsonResult<List<CategoryListItemVO>> listByParentId(Long parentId) {
        if (parentId == null || parentId < 0) {
            parentId = 0L;
        }
        List<CategoryListItemVO> list = categoryService.listByParentId(parentId);
        return JsonResult.ok(list);
    }
}
