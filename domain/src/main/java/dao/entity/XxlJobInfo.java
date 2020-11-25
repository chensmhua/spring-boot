package dao.entity;



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.dao.entity$
 * @ClassName: XxlJobInfoMapper$
 * @date ：Created in 2020-08-25 15:53
 * @description：
 * @modified By：
 * @version: 1.01
 */
@Table(name = "xxl_job_info")
@Entity
@Data
public class XxlJobInfo implements Serializable {
    // 主键ID
    @Id
    private int id;

    // 执行器主键ID
    @Column(name = "job_group")
    private int jobGroup;
    // 任务执行CRON表达式
    @Column(name = "job_cron")
    private String jobCron;
    //任务描述
    @Column(name = "job_desc")
    private String jobDesc;
    //任务添加时间
    @Column(name = "add_time")
    private Date addTime;
    //任务修改时间
    @Column(name = "update_time")
    private Date updateTime;
    // 负责人
    @Column(name = "author")
    private String author;
    // 报警邮件
    @Column(name = "alarm_email")
    private String alarmEmail;
    // 执行器路由策略
    @Column(name = "executor_route_strategy")
    private String executorRouteStrategy;
    // 执行器，任务Handler名称
    @Column(name = "executor_handler")
    private String executorHandler;
    // 执行器，任务参数
    @Column(name = "executor_param")
    private String executorParam;
    // 阻塞处理策略
    @Column(name = "executor_block_strategy")
    private String executorBlockStrategy;
    // 任务执行超时时间，单位秒
    @Column(name = "executor_timeout")
    private int executorTimeout;
    // 失败重试次数
    @Column(name = "executor_fail_retry_count")
    private int executorFailRetryCount;
    // GLUE类型	#com.xxl.job.core.glue.GlueTypeEnum
    @Column(name = "glue_type")
    private String glueType;
    // GLUE源代码
    @Column(name = "glue_source")
    private String glueSource;
    // GLUE备注
    @Column(name = "glue_remark")
    private String glueRemark;
    // GLUE更新时间
    @Column(name = "glue_updatetime")
    private Date glueUpdatetime;
    // 子任务ID，多个逗号分隔
    @Column(name = "child_jobid")
    private String childJobId;
    // 调度状态：0-停止，1-运行
    @Column(name = "trigger_status")
    private int triggerStatus;
    // 上次调度时间
    @Column(name = "trigger_last_time")
    private long triggerLastTime;
    // 下次调度时间
    @Column(name = "trigger_next_time")
    private long triggerNextTime;
    //任务id
    @Column(name = "handler_id")
    private Integer handlerId;
    //任务名称
    @Column(name = "executor_name")
    private String executorName;
    //电话号码
    @Column(name = "user_phone")
    private String userPhone;

}
