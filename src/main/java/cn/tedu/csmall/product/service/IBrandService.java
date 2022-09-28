package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;

public interface IBrandService {

    void addNew(BrandAddNewDTO brandAddNewDTO);

    void delete(Long id);

}
