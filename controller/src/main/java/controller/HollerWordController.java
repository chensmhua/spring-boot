package controller;

import com.chd.stater.MySpringBootStarter;
import com.chd.stater.MySpringBootStarterConfiguration;
import dao.entity.XxlJobInfo;
import dao.mapper.XxlJobInfoMapper;
import dao.repository.XxlJobInfoRepository;
import dao.util.RedisUtil;
import dao.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.controller$
 * @ClassName: HollerWordController$
 * @date ：Created in 2020-06-19 11:31
 * @description：controller
 * @modified By：
 * @version: 1.01
 */
@Controller
@RequestMapping("test")
public class HollerWordController {

    @Autowired
    private XxlJobInfoRepository xxlJobInfoRepository;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    DataSource dataSource;

    @Autowired
    private MySpringBootStarterConfiguration mySpringBootStarterConfiguration;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 测试hello
     *
     * @return
     */
    @RequestMapping("hello")
    public String hello() {
        return "hello word!";
    }


    //@Cacheable(cacheNames = "xxlJobInfo",keyGenerator = "myKeyGenerator")
    @Cacheable(cacheNames = "xxlJobInfo",key = "#id")
    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    @ResponseBody
    public XxlJobInfo findAll(Integer id) {
        XxlJobInfo all = xxlJobInfoRepository.findById(id);
        return all;
    }

    @RequestMapping("dataSource")
    public void checkDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
    }

    @RequestMapping("myStarter")
    @ResponseBody
    public String getName(){
        MySpringBootStarter mySpringBootStarter = mySpringBootStarterConfiguration.mySpringBootStarter();
        String ces = mySpringBootStarter.getName("ces");
        return ces;
    }

    /**
     * redis测试
     */
    @RequestMapping("redis")
    @ResponseBody
    public String redis(){
        Object chd = redisUtil.get("chd");
        String s = String.valueOf(chd);
        return s;
    }

    /**
     * 删除缓存
     * @param id
     * @return
     */
    @CacheEvict(value = "xxlJobInfo",key = "#id")
    @RequestMapping(value = "deleteCache",method = RequestMethod.POST)
    @ResponseBody
    public String delete(Integer id){
        return  "sucess";
    }




}