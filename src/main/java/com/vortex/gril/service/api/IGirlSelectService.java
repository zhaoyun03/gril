package com.vortex.gril.service.api;

import com.vortex.gril.entrty.Girl;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 * Description:
 * Created with IntelliJ IDEA.
 *
 * @author: zzy
 * @date: 2017/10/26 0026 Version: V1.0.0
 */
public interface IGirlSelectService {

    /**
     * 通过年龄查询女孩
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);

    /**
     * 通过查询数据
     * @param cupSize
     * @return
     */
    List<Girl> findByCupSize(String cupSize);

    /**
     * 无条件分页查询女生
     * @param page
     * @param size
     * @return
     */
    Page<Girl> findGirlNoCriteria(Integer page,Integer size);

    /**
     *通过年龄查询女孩，并将结果分页
     * @param age
     * @param page
     * @param size
     * @return
     */
    Page<Girl> findByAge(Integer age,Integer page,Integer size);

    /**
     * 通过姓名查找女孩
     * @param name
     * @return
     */
    List<Girl>  findByName(String name);

    /**
     *通过姓名和年龄查询女生
     * @param name
     * @param age
     * @return
     */
    List<Girl>findByNameAndAge(String name,Integer age);
}
