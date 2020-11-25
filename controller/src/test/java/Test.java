import controller.ApplicationSpringBoot;
import dao.entity.XxlJobInfo;
import dao.repository.XxlJobInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: PACKAGE_NAME$
 * @ClassName: Test$
 * @date ：Created in 11/20/20 2:15 PM
 * @description：测试类
 * @modified By：
 * @version: 1.01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = ApplicationSpringBoot.class)
@Slf4j
public class Test {

    @Autowired
    private XxlJobInfoRepository xxlJobInfoRepository;
    
    /**
     * 预销账金额报表数据>>FTP
     */
    @org.junit.Test
    public void  Test() throws Exception {
        List<XxlJobInfo> all = xxlJobInfoRepository.findAll();
    }
}