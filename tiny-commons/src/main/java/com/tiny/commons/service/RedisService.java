package com.tiny.commons.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis操作接口
 *
 * @author knox
 * @since 2020/08/08
 */
public interface RedisService {

    /**
     * 保存属性
     *
     * @param key   缓存key
     * @param value 缓存value
     * @param time  缓存时效，秒
     */
    void set(String key, Object value, long time);

    /**
     * 保存属性
     *
     * @param key   缓存key
     * @param value 缓存value
     */
    void set(String key, Object value);

    /**
     * 获取属性
     *
     * @param key 缓存key
     * @return 缓存对象
     */
    Object get(String key);

    /**
     * 删除属性
     *
     * @param key 缓存key
     * @return 是否删除成功
     */
    Boolean del(String key);

    /**
     * 批量删除属性
     *
     * @param keys 缓存key集合
     * @return 批量删除成功数
     */
    Long del(List<String> keys);

    /**
     * 设置过期时间
     *
     * @param key  缓存key
     * @param time 缓存时效，秒
     * @return 是否失效
     */
    Boolean expire(String key, long time);

    /**
     * 获取过期时间
     *
     * @param key 缓存key
     * @return 失效时间
     */
    Long getExpire(String key);

    /**
     * 判断是否有该属性
     *
     * @param key 缓存key
     * @return 是否有当前缓存key
     */
    Boolean hasKey(String key);

    /**
     * 按delta递增
     *
     * @param key   缓存key
     * @param delta delta
     * @return
     */
    Long incr(String key, long delta);

    /**
     * 按delta递减
     *
     * @param key   缓存key
     * @param delta delta
     * @return
     */
    Long decr(String key, long delta);

    /**
     * 获取Hash结构中的属性
     *
     * @param key     缓存key
     * @param hashKey hashKey
     * @return hash属性
     */
    Object hGet(String key, String hashKey);

    /**
     * 向Hash结构中放入一个属性
     */
    Boolean hSet(String key, String hashKey, Object value, long time);

    /**
     * 向Hash结构中放入一个属性
     */
    void hSet(String key, String hashKey, Object value);

    /**
     * 直接获取整个Hash结构
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * 直接设置整个Hash结构
     */
    Boolean hSetAll(String key, Map<String, Object> map, long time);

    /**
     * 直接设置整个Hash结构
     */
    void hSetAll(String key, Map<String, ?> map);

    /**
     * 删除Hash结构中的属性
     */
    void hDel(String key, Object... hashKey);

    /**
     * 判断Hash结构中是否有该属性
     */
    Boolean hHasKey(String key, String hashKey);

    /**
     * Hash结构中属性递增
     */
    Long hIncr(String key, String hashKey, Long delta);

    /**
     * Hash结构中属性递减
     */
    Long hDecr(String key, String hashKey, Long delta);

    /**
     * 获取Set结构
     */
    Set<Object> sMembers(String key);

    /**
     * 向Set结构中添加属性
     */
    Long sAdd(String key, Object... values);

    /**
     * 向Set结构中添加属性
     */
    Long sAdd(String key, long time, Object... values);

    /**
     * 是否为Set中的属性
     */
    Boolean sIsMember(String key, Object value);

    /**
     * 获取Set结构的长度
     */
    Long sSize(String key);

    /**
     * 删除Set结构中的属性
     */
    Long sRemove(String key, Object... values);

    /**
     * 获取List结构中的属性
     */
    List<Object> lRange(String key, long start, long end);

    /**
     * 获取List结构的长度
     */
    Long lSize(String key);

    /**
     * 根据索引获取List中的属性
     */
    Object lIndex(String key, long index);

    /**
     * 向List结构中添加属性
     */
    Long lPush(String key, Object value);

    /**
     * 向List结构中添加属性
     */
    Long lPush(String key, Object value, long time);

    /**
     * 向List结构中批量添加属性
     */
    Long lPushAll(String key, Object... values);

    /**
     * 向List结构中批量添加属性
     */
    Long lPushAll(String key, Long time, Object... values);

    /**
     * 从List结构中移除属性
     */
    Long lRemove(String key, long count, Object value);
}
