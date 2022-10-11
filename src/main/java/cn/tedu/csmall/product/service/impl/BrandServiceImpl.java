package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    BrandMapper brandMapper;

    public BrandServiceImpl() {
        log.info("创建业务实现类对象：BrandServiceImpl");
    }

    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        String name = brandAddNewDTO.getName();
        int count = brandMapper.countByName(name);
        if(count != 0){
            throw new ServiceException(ServiceCode.ERR_CONFLICT,"添加品牌失败,尝试添加的品牌名称已经被占用!");
        }

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        brandMapper.insert(brand);
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除品牌】的业务，参数：{}", id);

        BrandStandardVO queryResult = brandMapper.getStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：无此id对应的数据，抛出异常
            String message = "删除品牌失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        // 调用Mapper对象的deleteById()方法执行删除
        log.debug("即将删除品牌数据……");
        brandMapper.deleteById(id);
        log.debug("删除品牌，完成！");
    }

    @Override
    public void setEnable(Long id) {
        updateEnableById(id, 1);
    }

    @Override
    public void setDisable(Long id) {
        updateEnableById(id, 0);
    }

    @Override
    public List<BrandListItemVO> list() {
        log.debug("开始处理【查询品牌列表】的业务……");
        return brandMapper.list();
    }

    private void updateEnableById(Long id, Integer enable) {
        String[] tips = {"禁用", "启用"};
        log.debug("开始处理【{}品牌】的业务，参数：{}", tips[enable], id);

        // 检查尝试访问的数据是否存在
        BrandStandardVO queryResult = brandMapper.getStandardById(id);
        if (queryResult == null) {
            String message = tips[enable] + "品牌失败，尝试访问的数据不存在！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        // 判断状态是否冲突（当前已经是目标状态）
        if (queryResult.getEnable() == enable) {
            String message = tips[enable] + "品牌失败，品牌已经处于" + tips[enable] + "状态！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        // 准备执行更新
        Brand brand = new Brand();
        brand.setId(id);
        brand.setEnable(enable);
        int rows = brandMapper.updateById(brand);
        if (rows != 1) {
            String message = tips[enable] + "品牌失败，服务器忙，请稍后再次尝试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
    }

}
