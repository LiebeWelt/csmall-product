package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理类别数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Repository
public interface CategoryMapper {

    /**
     * 插入类别数据
     *
     * @param category 类别数据
     * @return 受影响的行数
     */
    int insert(Category category);

    /**
     * 批量插入类别数据
     *
     * @param categoryList 若干个类别数据的集合
     * @return 受影响的行数
     */
    int insertBatch(List<Category> categoryList);

    /**
     * 根据id删除类别数据
     *
     * @param id 类别id
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 批量删除类别
     *
     * @param ids 需要删除的若干个类别的id
     * @return 受影响的行数
     */
    int deleteByIds(Long[] ids);

    /**
     * 更新类别数据
     *
     * @param category 封装了类别的id和需要更新的新数据的对象
     * @return 受影响的行数
     */
    int updateById(Category category);

    /**
     * 统计类别数据的数量
     *
     * @return 类别数据的数量
     */
    int count();

    /**
     * 根据id查询类别标准信息
     *
     * @param id 类别id
     * @return 匹配的类别的标准信息，如果没有匹配的数据，则返回null
     */
    CategoryStandardVO getStandardById(Long id);

    /**
     * 查询类别列表
     *
     * @return 类别列表
     */
    List<CategoryListItemVO> list();

}
