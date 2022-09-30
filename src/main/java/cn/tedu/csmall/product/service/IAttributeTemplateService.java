package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;

import java.util.List;

public interface IAttributeTemplateService {

    void addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO);

    void delete(Long id);

    List<AttributeTemplateListItemVO> list();
}
