package com.tiny.service.user.controller;

import com.tiny.commons.api.ApiResult;
import com.tiny.entity.ums.UmsAdminUser;
import com.tiny.service.user.model.dto.UmsAdminUserRegisterDTO;
import com.tiny.service.user.service.IUmsAdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author knox
 * @since 2021-01-09
 */
@RestController
@RequestMapping("/user")
public class UmsAdminUserController {
    @Resource
    private IUmsAdminUserService iUmsAdminUserService;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public ApiResult<UmsAdminUser> register(@Validated @RequestBody UmsAdminUserRegisterDTO dto) {
        UmsAdminUser umsAdminUser = iUmsAdminUserService.register(dto);
        if (umsAdminUser == null) {
            return ApiResult.failed("注册失败");
        }
        return ApiResult.success(umsAdminUser, "注册成功");
    }

    @ApiOperation(value = "根据 ID 查询用户信息")
    @GetMapping(value = {"{id}"})
    public ApiResult<UmsAdminUser> getUserById(@PathVariable String id) {
        UmsAdminUser dbUser = iUmsAdminUserService.getById(id);
        return ApiResult.success(dbUser, "用户检索成功");
    }
}
