package com.tiny.service.user.controller;

import com.tiny.commons.api.ApiResult;
import com.tiny.entity.ums.TbUser;
import com.tiny.service.user.service.ITbUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author knox
 * @since 2020-12-20
 */
@RestController
@RequestMapping("/user")
public class TbUserController {

    @Resource
    private ITbUserService iTbUserService;

    /**
     * 根据 ID 测试查询用户信息
     *
     * @param id 用户ID
     * @return {@link TbUser}
     */
    @GetMapping(value = {"{id}"})
    public ApiResult<TbUser> reg(@PathVariable String id) {
        TbUser dbUser = iTbUserService.getUserById(id);
        return ApiResult.success(dbUser, "用户检索成功");
    }
}
