package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理品牌数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Repository
public interface BrandMapper {

    int insert(Brand brand);

    int insertBatch(List<Brand> brandList);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int updateById(Brand brand);

    int count();

    /**
     * 根据id查询品牌标准信息
     *
     * @param id 品牌id
     * @return 匹配的品牌的标准信息，如果没有匹配的数据，则返回null
     */
    BrandStandardVO getStandardById(Long id);

    List<BrandListItemVO> list();

}
