package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.service.IAlbumService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service /*@Scope("prototype")*/
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    public AlbumServiceImpl() {
        log.info("创建业务对象：AlbumServiceImpl");
    }

    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO) {
        String name = albumAddNewDTO.getName();
        int countByName = albumMapper.countByName(name);
        if (countByName != 0) {
            throw new ServiceException(ServiceCode.ERR_CONFLICT,"添加相册失败,尝试添加的相册名称已经被占用!");
        }

        // 创建Album对象
        Album album = new Album();
        BeanUtils.copyProperties(albumAddNewDTO, album);
        albumMapper.insert(album);
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除相册】的业务，参数：{}", id);
        // 调用Mapper对象的getDetailsById()方法执行查询
        AlbumStandardVO queryResult = albumMapper.getStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：无此id对应的数据，抛出异常
            String message = "删除相册失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }

        // 调用Mapper对象的deleteById()方法执行删除
        log.debug("即将删除相册数据……");
        albumMapper.deleteById(id);
        log.debug("删除相册，完成！");
    }

    @Override
    public List<AlbumListItemVO> list() {
        log.debug("开始处理【查询相册列表】的业务……");
        return albumMapper.list();
    }
}
