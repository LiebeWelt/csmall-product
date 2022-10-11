package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AttributeUpdateInfoDTO;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import cn.tedu.csmall.product.service.IAttributeService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 处理属性相关请求的控制器
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Api(tags = "07. 属性管理模块")
@Slf4j
@RestController
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    private IAttributeService attributeService;

    public AttributeController() {
        log.info("创建控制器：AttributeController");
    }

    // http://localhost:9080/attributes/add-new
    @ApiOperation("添加属性")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult<Void> addNew(AttributeAddNewDTO attributeAddNewDTO) {
        log.debug("开始处理【添加属性】的请求：{}", attributeAddNewDTO);
        attributeService.addNew(attributeAddNewDTO);
        return JsonResult.ok();
    }

    // http://localhost:9080/attributes/9527/delete
    @ApiOperation("根据id删除属性")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id", value = "属性id", required = true, dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete(@PathVariable Long id) {
        log.debug("开始处理【删除属性】的请求：id={}", id);
        attributeService.deleteById(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/attributes/9527/info/update
    @ApiOperation("修改属性基本资料")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParam(name = "id", value = "属性id", required = true, dataType = "long")
    @PostMapping("/{id:[0-9]+}/info/update")
    public JsonResult<Void> updateInfoById(@PathVariable Long id, AttributeUpdateInfoDTO attributeUpdateInfoDTO) {
        log.debug("开始处理【修改属性基本资料】的请求，id={}，新基本资料={}", attributeUpdateInfoDTO);
        attributeService.updateInfoById(id, attributeUpdateInfoDTO);
        return JsonResult.ok();
    }

    // http://localhost:9080/attributes/list-by-template
    @ApiOperation("根据属性模板查询属性列表")
    @ApiOperationSupport(order = 410)
    @ApiImplicitParam(name = "templateId", value = "属性模板id",
            required = true, dataType = "long")
    @GetMapping("/list-by-template")
    public JsonResult<List<AttributeListItemVO>> listByTemplateId(Long templateId) {
        List<AttributeListItemVO> list = attributeService.listByTemplateId(templateId);
        return JsonResult.ok(list);
    }

}
