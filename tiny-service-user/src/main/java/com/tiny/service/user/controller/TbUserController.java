package com.tiny.service.user.controller;

import com.tiny.commons.domain.TbUserEntity;
import com.tiny.commons.mapper.TbUserMapper;
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
    private TbUserMapper tbUserMapper;

    /**
     * 根据 ID 测试查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = {"{id}"})
    public String reg(@PathVariable String id) {
        TbUserEntity tbUser = tbUserMapper.selectById(id);
        // int i = 1 / 0; 模拟 skywalking
        return tbUser.getUsername();
    }
}
