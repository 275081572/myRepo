package com.cn.smart.controller.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/4/19
 */

public class StopwatchTest {

    public static void main(String[] args) throws InterruptedException {
        // 创建stopwatch并开始计时
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(1980);
        // 以秒打印从计时开始至现在的所用时间，向下取整
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
        // 停止计时
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
        // 再次计时
        stopwatch.start();
        Thread.sleep(100);
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
        // 重置并开始
        stopwatch.reset().start();
        Thread.sleep(1030);
        // 检查是否运行
        System.out.println(stopwatch.isRunning());
        long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(millis);
        // 打印
        System.out.println(stopwatch);
    }
}
