package dao.repository;

import dao.entity.XxlJobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.dao.repository$
 * @ClassName: XxlJobInfoRepository$
 * @date ：Created in 2020-08-25 15:57
 * @description：接口
 * @modified By：
 * @version: 1.01
 */
@Repository
public interface XxlJobInfoRepository extends JpaRepository<XxlJobInfo, String> {

    XxlJobInfo findById(Integer id);
}
