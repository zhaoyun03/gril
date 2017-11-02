package com.vortex.gril;

import com.vortex.gril.dao.api.IGirlRepository;
import com.vortex.gril.entrty.Girl;
import com.vortex.gril.service.api.IGirlSelectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Created with IntelliJ IDEA.
 * @author: zzy
 * @date: 2017/10/26 0026 Version: V1.0.0
 */
@RestController
public class GirlController {

    @Autowired
    private IGirlRepository girlRepository;
    @Autowired
    private IGirlSelectService girlSelectService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 分页显示所有女生
     * @param page
     * @param size
     * @return
     */
   @PostMapping(value = "/girls/paging")
    public Page<Girl> girlList(@RequestParam(value = "page",defaultValue = "0") Integer page,
                               @RequestParam(value = "size",defaultValue = "5") Integer size) {
        Page<Girl> all = girlSelectService.findGirlNoCriteria(page, size);
        return  all;
    }

   /* @GetMapping(value = "/girls/pading/age/{age}")
    public Page<Girl> girlListByAge(@PathVariable("age") Integer age,
                                    @RequestParam(value = "page",defaultValue = "0") Integer page,
                                    @RequestParam(value = "size",defaultValue = "5") Integer size){
       Page<Girl>  girls = girlSelectService.findByAge(age,page,size);
       return girls;
    }*/

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls/add")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age,
                        @RequestParam("name") String name){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 根据Id查找一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "girls/selectById")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 通过姓名查找所有女生
     * @param name
     * @return
     */
    @GetMapping(value = "girls/name/")
    public List<Girl> girlFindByName(@PathVariable("name") String name){
        return girlSelectService.findByName(name);
    }

    /**
     * 更新一个女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "girls/girlUpdate")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age,
                           @RequestParam("name") String name){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 根据id删除一个女生
     * @param id
     */
    @DeleteMapping(value = "girls/delete/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
          girlRepository.delete(id);
    }

    /**
     * 根据年龄查询女生
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlSelectService.findByAge(age);
    }

    @GetMapping(value = "/girls/nameAndAge/{name}/{age}")
    public List<Girl> girlListByNameAndAge(@PathVariable("name") String name,@PathVariable("age") Integer age){
        return  girlSelectService.findByNameAndAge(name, age);
    }

    /**
     * 根据查找女生
     * @param cupSize
     * @return
     */
    @GetMapping(value = "girls/cupSize/{cupSize}")
    public List<Girl> girlListByCupSize(@PathVariable("cupSize") String cupSize){
        return girlSelectService.findByCupSize(cupSize);
    }
}
