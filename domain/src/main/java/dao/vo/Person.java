package dao.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.dao.vo$
 * @ClassName: Person$
 * @date ：Created in 2020-07-26 21:26
 * @description：人
 * @modified By：
 * @version: 1.01
 */

@Component
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
public class Person implements Serializable {

    //名字
    @Value("{person.name}")
    private String name;
    //年龄
    private Integer age;
    //性别
    private String sex;

    public String getInfo(){
        return name+age+sex;
    }



}