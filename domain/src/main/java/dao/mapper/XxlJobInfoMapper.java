package dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dao.entity.XxlJobInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.dao.mapper$
 * @ClassName: XxlJobInfoMapper$
 * @date ：Created in 2020-08-31 16:53
 * @description：xml
 * @modified By：
 * @version: 1.01
 */
@Mapper
public interface XxlJobInfoMapper extends BaseMapper<XxlJobInfo> {

    List<XxlJobInfo> findAll();
}
