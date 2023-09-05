package com.github.monster.core.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 定时任务
 */
@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class Task implements Runnable {
    /**
     * 任务名字
     */
    public String name;
    /**
     * 触发条件
     */
    public Date startTime;
    /**
     * 两次任务之间的执行间隔时间
     */
    public long duration;
    /**
     * 延迟时间
     */
    public long delay;

    private TaskExecution taskExecution;

    public void AbstractTask(String name, Date startTime, long duration, long delay, TaskExecution taskExecution) {
        this.name = name;
        this.startTime = startTime;
        this.duration = duration;
        this.delay = delay;
        this.taskExecution = taskExecution;
    }

    @Override
    public void run() {
        log.info("当前任务名称：{}", name);
        taskStart();
    }

    private void taskStart() {
        // 执行任务
        if (taskExecution != null) {
            taskExecution.execute();
        }
    }
}