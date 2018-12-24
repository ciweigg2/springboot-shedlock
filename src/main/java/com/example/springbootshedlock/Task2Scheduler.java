package com.example.springbootshedlock;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 马秀成
 * @date 2018/12/24
 * @jdk.version 1.8
 * @desc
 */
@Component
@Slf4j
class Task2Scheduler {

    @Scheduled(cron = "*/1 * * * * ?")
    @SchedulerLock(name = "TaskScheduler_scheduledTask",
            lockAtLeastForString = "PT1M", lockAtMostForString = "PT2M")
    public void scheduledTask() throws InterruptedException {
        log.info("开始睡眠当前时间"+System.currentTimeMillis());
//        Thread.sleep(1000 * 60 *3);
        log.info("结束睡眠当前时间"+System.currentTimeMillis());
    }
}
