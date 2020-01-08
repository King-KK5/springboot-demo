package com.emotte.springbootdemo.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    //Java Cron表达式
    @Scheduled(cron = "0 * 9 * * ?")
    public void cronJobSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }

    //固定速率,固定速率调度程序用于在特定时间执行任务。它不等待前一个任务的完成。 值是以毫秒为单位。
    //应用程序启动时每秒执行任务
    @Scheduled(fixedRate = 1000)
    public void fixedRateSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Rate scheduler:: " + strDate);
    }

    //固定延迟,固定延迟调度程序用于在特定时间执行任务。 它应该等待上一个任务完成。 值应以毫秒为单位。
    //从应用程序启动完成3秒后每秒执行一次任务
    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    public void fixedDelaySch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Delay scheduler:: " + strDate);
    }



}
