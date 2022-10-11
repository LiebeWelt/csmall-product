package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AttributeUpdateInfoDTO;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 属性业务接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Transactional
public interface IAttributeService {

    /**
     * 添加属性
     *
     * @param attributeAddNewDTO 添加的属性对象
     */
    void addNew(AttributeAddNewDTO attributeAddNewDTO);

    /**
     * 删除属性
     *
     * @param id 被删除的属性的id
     */
    void deleteById(Long id);

    /**
     * 修改属性基本资料
     *
     * @param id                     属性id
     * @param attributeUpdateInfoDTO 封装了新基本资料的对象
     */
    void updateInfoById(Long id, AttributeUpdateInfoDTO attributeUpdateInfoDTO);

    /**
     * 根据属性模板id查询属性列表
     *
     * @param templateId 属性模板id
     * @return 属性列表的集合
     */
    List<AttributeListItemVO> listByTemplateId(Long templateId);

}
