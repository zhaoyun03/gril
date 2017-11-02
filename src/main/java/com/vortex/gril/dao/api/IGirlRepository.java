package com.vortex.gril.dao.api;

import com.vortex.gril.entrty.Girl;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Created with IntelliJ IDEA.
 * @author: zzy
 * @date: 2017/10/26 0026 Version: V1.0.0
 */
@Repository
public interface IGirlRepository extends JpaRepository<Girl,Integer>,JpaSpecificationExecutor<Girl> {

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
     * 通过姓名查找女生
     * @param name
     * @return
     */
     List<Girl> findByName(String name);

    /**
     * 通过姓名和年龄查询数据
     * @param name
     * @param age
     * @return
     */
    List<Girl>findByNameAndAge(String name,Integer age);
}
