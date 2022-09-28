package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;

public interface ICategoryService {

    void addNew(CategoryAddNewDTO categoryAddNewDTO);

    void delete(Long id);

}
