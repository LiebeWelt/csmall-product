package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.service.IAttributeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttributeTemplateController {

    @Autowired
    IAttributeTemplateService attributeTemplateService;

    @RequestMapping("/attributeTemplate/add-new")
    public String addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO){

        try {
            attributeTemplateService.addNew(attributeTemplateAddNewDTO);
            return "添加模板成功";
        } catch (RuntimeException e) {
            return "添加模板失败,名称已被占用";
        }

    }
}
