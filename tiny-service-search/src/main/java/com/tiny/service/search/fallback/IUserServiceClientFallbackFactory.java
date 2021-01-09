package com.tiny.service.search.fallback;

import com.tiny.commons.api.ApiResult;
import com.tiny.entity.ums.TbUser;
import com.tiny.service.search.service.IUserServiceClient;
import org.springframework.stereotype.Component;

/**
 * 用户服务实现类
 * <p>
 * Sentinel服务熔断处理
 *
 * @author knox
 * @since 2021-01-09
 */
@Component
public class IUserServiceClientFallbackFactory implements IUserServiceClient {

    @Override
    public ApiResult<TbUser> getUserById(String id) {
        return ApiResult.failed("服务异常，用户数据获取失败");
    }
}
