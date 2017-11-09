package com.vortex.gril.service.impl;

import com.vortex.gril.dao.api.JedisClient;
import com.vortex.gril.service.api.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Created with IntelliJ IDEA.
 *
 * @author: zzy
 * @date: 2017/11/9 0009 Version: V1.0.0
 */
@Service
public class RedisServiceImpl implements RedisService{

    @Autowired
    private JedisClient jedisClient;
}
