package com.vortex.gril.dao.api;

/**
 * Description:
 * Created with IntelliJ IDEA.
 *
 * @author: zzy
 * @date: 2017/11/8 0008 Version: V1.0.0
 */
public interface JedisClient {

    /**
     * 获取value
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 存放key
     * @param key
     * @param value
     * @return
     */
    String set(String key,String value);

    /**
     * 获取hash
     * @param hkey
     * @param key
     * @return
     */
    String hget(String hkey,String key);

    /**
     * 存放
     * @param hkey
     * @param key
     * @param value
     * @return
     */
    long hset(String hkey,String key,String value);

    /**
     * 设置自增
     * @param key
     * @return
     */
    long inir(String key);

    /**
     * 设置过期时间
     */
    long expire(String key,int second);

    /**
     * 查看过期时间
     * @param key
     * @return
     */
    long ttl(String key);

    /**
     * 删除缓存中的key
     * @param key
     * @return
     */
    long del(String key);

    /**
     * 查看Key是否存在
     * @param key
     */
    boolean exists(String key);

}
