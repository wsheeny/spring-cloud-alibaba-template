package com.tiny.service.search.controller;

import com.tiny.commons.api.ApiResult;
import com.tiny.entity.ums.TbUser;
import com.tiny.service.search.service.IUserServiceClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户检索
 *
 * @author knox
 * @since 2021-01-09
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserSearchController", description = "用户检索处理器")
public class UserSearchController {

    @Resource
    private IUserServiceClient iUserServiceClient;

    @ApiOperation(value = "searchUser", notes = "获取用户数据")
    @GetMapping("/{id}")
    public ApiResult<TbUser> searchUser(@PathVariable("id") String id) {
        return iUserServiceClient.getUserById(id);
    }
}
