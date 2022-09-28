package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;

public interface IAttributeTemplateService {

    void addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO);

    void delete(Long id);
}
