package com.tiny.entity.ums;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author knox
 * @since 2020-08-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("ums_admin_user")
@ApiModel(value = "UmsAdminUser对象", description = "后台用户表")
public class UmsAdminUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField("username")
    @ApiModelProperty(value = "账号", name = "username")
    private String username;

    @JsonIgnore
    @TableField("password")
    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    @TableField("avatar")
    @ApiModelProperty(value = "头像", name = "avatar")
    private String avatar;

    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;

    @ApiModelProperty(value = "昵称", name = "alias")
    private String alias;

    @ApiModelProperty(value = "备注信息", name = "note")
    private String note;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "最后登录时间", name = "loginTime")
    private Date loginTime;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用", name = "status")
    private Boolean status;
}
