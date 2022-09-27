package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.mapper.AttributeTemplateMapper;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.service.IAttributeTemplateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeTemplateServiceImpl implements IAttributeTemplateService {

    @Autowired
    AttributeTemplateMapper attributeTemplateMapper;

    public AttributeTemplateServiceImpl() {
        System.out.println(123);
    }

    @Override
    public void addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO) {
        String name = attributeTemplateAddNewDTO.getName();

        int count = attributeTemplateMapper.countByName(name);

        if(count != 0){
            throw new RuntimeException("");
        }

        AttributeTemplate attributeTemplate = new AttributeTemplate();
        BeanUtils.copyProperties(attributeTemplateAddNewDTO,attributeTemplate);
        attributeTemplateMapper.insert(attributeTemplate);
    }
}
