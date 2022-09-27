package cn.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttributeTemplate {
    private Long id;

    private String name;

    private String pinyin;

    private String keywords;

    private Integer sort;

    private LocalDateTime gmt_create;

    private LocalDateTime gmt_modified;
}
/*        `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
        `name` varchar(50) DEFAULT NULL COMMENT '属性模版名称',
        `pinyin` varchar(50) DEFAULT NULL COMMENT '属性模版名称的拼音',
        `keywords` varchar(255) DEFAULT NULL COMMENT '关键词列表，各关键词使用英文的逗号分隔',
        `sort` tinyint unsigned DEFAULT '0' COMMENT '自定义排序序号',
        `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
        `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
        PRIMARY KEY (`id`)*/
