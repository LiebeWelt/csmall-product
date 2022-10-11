package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;

import java.util.List;

public interface IBrandService {

    void addNew(BrandAddNewDTO brandAddNewDTO);

    void delete(Long id);

    void setEnable(Long id);

    void setDisable(Long id);

    List<BrandListItemVO> list();

}
