package com.cn.smart.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();

        //创建10个任务并执行
        for (int i = 0; i < 10; i++){
            //使用ExecuorService执行callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TaskWithResult(i));
            //将任务执行结果存储到List中
            resultList.add(future);
        }

        //遍历任务结果
        for(Future<String> fs: resultList){
            try {
                //一直循环等待直到Future返回完成
                while (!fs.isDone());
                System.out.println(fs.get());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }
        }
    }
}
