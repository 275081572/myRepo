package com.cn.smart.controller.guava;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/6/7
 */

public class CacheTest {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));

    // 模拟DB
    private static final HashMap<Integer, String> map = new HashMap<>();

    public static LoadingCache<Integer, String> createGuavaCache() {
        return CacheBuilder.newBuilder()
                // 设置并发级别为5，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(5)
                // 设置写缓存后10秒钟后过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                // 设置缓存容器的初始容量为8
                .initialCapacity(8)
                // 设置缓存最大容量为10，超过10之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(10)
                // 设置统计缓存的各种统计信息
                .recordStats()
                // 设置缓存的移除通知（同步）
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                // 设置缓存的移除通知（异步）
                // .removalListener(RemovalListeners.asynchronous(new RemovalListener<Object, Object>() {
                // @Override
                // public void onRemoval(RemovalNotification<Object, Object> notification) {
                // // TODO
                // }
                // }, threadPoolExecutor))
                // 指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        System.out.println("查询key:" + key + "的数据");
                        // 模拟从DB中查询数据
                        return map.get(key);
                    }
                });
    }

    public static void main(String[] args) throws ExecutionException {
        map.put(1, "美孚");
        map.put(2, "1号");
        map.put(3, "车养护");

        LoadingCache<Integer, String> loadingCache = createGuavaCache();

        // 第一次缓存中没有数据，所以会往DB中查询数据
        System.out.println(loadingCache.get(2));
        // 第二次缓存中有数据，CacheLoader.load方法不会加载
        System.out.println(loadingCache.get(2));
        // 获取缓存命中记录
        System.out.println(loadingCache.stats().toString());
    }
}
