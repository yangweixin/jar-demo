package top.byoung.demo.jar.concurrency.threadpool.impl;

import top.byoung.demo.jar.concurrency.threadpool.DenyPolicy;
import top.byoung.demo.jar.concurrency.threadpool.RunnableQueue;
import top.byoung.demo.jar.concurrency.threadpool.ThreadPool;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue {

    private final LinkedList<Runnable> runnableList = new LinkedList<>();
    private final int limit;
    private final DenyPolicy denyPolicy;
    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if(runnableList.size() >= limit) {
                denyPolicy.reject(runnable, threadPool);
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException{
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    runnableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }

            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList) {
            return runnableList.size();
        }
    }
}
