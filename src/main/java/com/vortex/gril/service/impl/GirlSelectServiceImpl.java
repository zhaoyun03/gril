package com.vortex.gril.service.impl;


import com.vortex.gril.dao.api.IGirlRepository;
import com.vortex.gril.entrty.Girl;
import com.vortex.gril.service.api.IGirlSelectService;
import java.util.List;
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

    @Autowired
    private IGirlRepository girlRepository;

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
}
