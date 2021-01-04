package com.tiny.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * <p>
 * item商品表
 * </p>
 *
 * @author knox
 * @since 2020-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_item")
@ApiModel(value = "TbItemEntity对象", description = "item商品表")
@Document(indexName = "item", shards = 1, replicas = 1)
public class TbItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @Field(type = FieldType.Double)
    @ApiModelProperty(value = "价格")
    @TableField("price")
    private Double price;

    @Field(type = FieldType.Keyword)
    // @Parent(type = "brand")
    @ApiModelProperty(value = "品牌ID")
    @TableField("brand_id")
    private String brandId;


}
