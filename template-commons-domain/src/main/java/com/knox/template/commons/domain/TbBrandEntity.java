package com.knox.template.commons.domain;

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
 * 品牌表
 * </p>
 *
 * @author knox
 * @since 2020-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_brand")
@ApiModel(value = "TbBrandEntity对象", description = "品牌表")
@Document(indexName = "brand", shards = 1, replicas = 1)
public class TbBrandEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "品牌")
    @TableField("`title`")
    private String title;


}
