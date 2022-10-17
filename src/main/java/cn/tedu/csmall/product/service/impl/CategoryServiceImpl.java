package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.CategoryMapper;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.service.ICategoryService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryServiceImpl() {
        log.info("创建业务实现类对象：CategoryServiceImpl");
    }

    @Override
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        // 从参数categoryAddNewDTO中获取尝试添加的类别名称
        String name = categoryAddNewDTO.getName();
        // 检查此类别名称是否已经存在：调用Mapper对象的countByName()方法，判断结果是否不为0
        int count = categoryMapper.countByName(name);
        if (count != 0) {
            // 是：名称已存在，不允许创建，抛出异常
            throw new ServiceException(ServiceCode.ERR_CONFLICT,
                    "添加类别失败，尝试添加的类别名称已经被占用！");
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryAddNewDTO, category);
        categoryMapper.insert(category);
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除类别】的业务，参数：{}", id);

        CategoryStandardVO queryResult = categoryMapper.getStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：无此id对应的数据，抛出异常
            String message = "删除类别失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        // 调用Mapper对象的deleteById()方法执行删除
        log.debug("即将删除类别数据……");
        categoryMapper.deleteById(id);
        log.debug("删除类别，完成！");
    }

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始处理【查询相册列表】的业务……");
        return categoryMapper.list();
    }

    @Override
    public List<CategoryListItemVO> listByParentId(Long parentId) {
        return categoryMapper.listByParentId(parentId);
    }
}
