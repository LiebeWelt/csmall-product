package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;

import java.util.List;

public interface ICategoryService {

    void addNew(CategoryAddNewDTO categoryAddNewDTO);

    void delete(Long id);

    List<CategoryListItemVO> list();
}
