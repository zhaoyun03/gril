package com.vortex.gril.service.impl;


import com.alibaba.fastjson.JSON;
import com.vortex.common.service.impl.CentralCacheService;
import com.vortex.common.util.StringUtils;
import com.vortex.gril.dao.api.IGirlRepository;
import com.vortex.gril.dao.api.JedisClient;
import com.vortex.gril.entrty.Girl;
import com.vortex.gril.service.api.IGirlSelectService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * Description:查询女孩service层
 * Created with IntelliJ IDEA.
 * @author: zzy
 * @date: 2017/10/26 0026 Version: V1.0.0
 */
@Service
public class GirlSelectServiceImpl implements IGirlSelectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GirlSelectServiceImpl.class);

    @Autowired
    private IGirlRepository girlRepository;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public List<Girl> findAll() {
        try{
            String cacheGirlList = jedisClient.get("cacheGirlList");//首先从jedis中获取缓存
            if(!StringUtils.isBlank(cacheGirlList)) {//查看缓存是否存在
                List<Girl> GirlList = JSON.parseArray(cacheGirlList, Girl.class);//如果存在，转换成list
                return GirlList;//直接返回查询出的结果
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        List<Girl> girlList = girlRepository.findAll();
        try{
            String cacheGirlList = JSON.toJSONString(girlList);//先将数据转换为json数据
           jedisClient.set("cacheGirlList",cacheGirlList);//往缓存中添加数据
        }catch(Exception e){
            e.printStackTrace();
        }
        return girlList;
    }

    @Override
    public Girl findById(Integer id) {
        return girlRepository.findOne(id);
    }

    @Override
    public List<Girl> findByAge(Integer age) {
        return girlRepository.findByAge(age);
    }

    @Override
    public List<Girl> findByCupSize(String cupSize) {
        return girlRepository.findByCupSize(cupSize);
    }

    @Override
    public Page<Girl> findGirlNoCriteria(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page,size, Direction.ASC,"id");
        return girlRepository.findAll(pageable);
    }

    @Override
    public Page<Girl> findByAge(Integer age,Integer page, Integer size) {
        return null;
    }

    @Override
    public List<Girl> findByName(String name) {
        return girlRepository.findByName(name);
    }

    @Override
    public List<Girl> findByNameAndAge(String name, Integer age) {
        return girlRepository.findByNameAndAge(name,age);
    }

    @Override
    public Girl addGirl(Girl girl) {
        try {
            String key = "cacheGirlList";
            boolean haskey = jedisClient.exists(key);
            if (haskey){
                jedisClient.del(key);
                LOGGER.info("GirlSelectServiceImpl.addGirl() : 从缓存中删除女孩");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return girlRepository.save(girl);
    }

    @Override
    public Girl updateGirl(Girl girl) {
        String key = "cacheGirlList";
        try{
            boolean haskey = jedisClient.exists(key);
            if (haskey){
                jedisClient.del(key);
                LOGGER.info("GirlSelectServiceImpl.updateGirl() : 从缓存中删除女孩");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return girlRepository.save(girl);
    }

    @Override
    public void deleteGirl(Integer id) {
        String key = "cacheGirlList";
         try{
             boolean haskey = jedisClient.exists(key);
             if (haskey){
                 jedisClient.del(key);
                 LOGGER.info("GirlSelectServiceImpl.deleteGirl() : 从缓存中删除女孩");
             }
         }catch (Exception e){
             e.printStackTrace();
         }
        girlRepository.delete(id);
    }


}
