package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AlbumAddNewDTO implements Serializable{
    /**
     * 相册名称
     */
    private String name;

    /**
     * 相册简介
     */
    private String description;

    /**
     * 自定义排序序号
     */
    private Integer sort;

}