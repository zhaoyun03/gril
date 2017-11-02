package com.vortex.gril.dao.api;

/**
 * Description:处理数据dao层接口
 * Created with IntelliJ IDEA.
 * @author: zzy
 * @date: 2017/10/27 0027 Version: V1.0.0
 */
public interface IGirlSelectDao {

    /**
     * 通过id删除女生
     * @param id
     * @return
     */
    Boolean deleteById(Integer id);
}
