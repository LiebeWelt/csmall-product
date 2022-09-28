package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.service.IAttributeTemplateService;
import cn.tedu.csmall.product.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/attribute-template")
public class AttributeTemplateController {

    @Autowired
    IAttributeTemplateService attributeTemplateService;

    public AttributeTemplateController() {
        log.info("创建控制器：AttributeTemplateController");
    }

    //http://localhost:9080/attribute-template/add-new?name=Test001&pinyin=Test001&keywords=Test001&sort=77
    @RequestMapping("/add-new")
    public JsonResult addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO){
        log.debug("开始处理【添加属性模板】的请求，参数：{}", attributeTemplateAddNewDTO);
        attributeTemplateService.addNew(attributeTemplateAddNewDTO);
        return JsonResult.ok();
    }

    //http://localhost:9080/attribute-template/4/delete
    @RequestMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【删除属性模板】的请求，参数：{}", id);
        attributeTemplateService.delete(id);
        return JsonResult.ok();
    }
}
