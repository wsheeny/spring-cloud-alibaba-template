package com.tiny.service.search.service;

import com.tiny.commons.api.ApiResult;
import com.tiny.entity.ums.TbUser;
import com.tiny.service.search.config.MyFeignClientsConfiguration;
import com.tiny.service.search.fallback.IUserServiceClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户服务服务调用
 *
 * @author knox
 * @since 2021-01-09
 */
@FeignClient(value = "service-user", /*url = "localhost:9600//",*/fallback = IUserServiceClientFallbackFactory.class, configuration = MyFeignClientsConfiguration.class)
public interface IUserServiceClient {

    /**
     * 用户检索
     *
     * @param id 用户ID
     * @return {@link TbUser}
     */
    @RequestMapping(value = "api/ums/user/{id}", produces = "application/json;charset=UTF-8")
    ApiResult<TbUser> getUserById(@PathVariable("id") String id);
}
