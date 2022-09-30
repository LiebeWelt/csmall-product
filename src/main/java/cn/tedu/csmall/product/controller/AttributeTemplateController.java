package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.service.IAttributeTemplateService;
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
@RequestMapping("/attribute-template")
@Api(tags = "02. 属性模板管理模块")
public class AttributeTemplateController {

    @Autowired
    IAttributeTemplateService attributeTemplateService;

    public AttributeTemplateController() {
        log.info("创建控制器：AttributeTemplateController");
    }

    //http://localhost:9080/attribute-template/add-new?name=Test001&pinyin=Test001&keywords=Test001&sort=77
    @ApiOperation("添加属性模板")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO){
        log.debug("开始处理【添加属性模板】的请求，参数：{}", attributeTemplateAddNewDTO);
        attributeTemplateService.addNew(attributeTemplateAddNewDTO);
        return JsonResult.ok();
    }

    //http://localhost:9080/attribute-template/4/delete
    @ApiOperation("删除属性模板")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【删除属性模板】的请求，参数：{}", id);
        attributeTemplateService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/attribute-template
    @ApiOperation("查询属性模板列表")
    @ApiOperationSupport(order = 400)
    @GetMapping("")
    public JsonResult<List<AttributeTemplateListItemVO>> list() {
        log.debug("开始处理【查询属性模板列表】的请求……");
        List<AttributeTemplateListItemVO> list = attributeTemplateService.list();
        return JsonResult.ok(list);
    }
}
