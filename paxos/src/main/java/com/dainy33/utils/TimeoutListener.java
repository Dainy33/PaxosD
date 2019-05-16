package com.dainy33.utils;

/**
 * 定时器超时
 * Created by dainy33 on 2019-04-20.
 */
public interface TimeoutListener {
    /**
     * 定时器超时后需要执行的函数
     */
    void onTimeOut(int timerID);
}
