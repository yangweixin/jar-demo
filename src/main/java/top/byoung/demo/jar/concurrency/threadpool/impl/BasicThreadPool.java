package top.byoung.demo.jar.concurrency.threadpool.impl;

import top.byoung.demo.jar.concurrency.threadpool.DenyPolicy;
import top.byoung.demo.jar.concurrency.threadpool.RunnableQueue;
import top.byoung.demo.jar.concurrency.threadpool.ThreadFactory;
import top.byoung.demo.jar.concurrency.threadpool.ThreadPool;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class BasicThreadPool extends Thread implements ThreadPool {


    private final ThreadFactory threadFactory;
    private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();
    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();
    private final int initSize;
    private final int maxSize;
    private final int coreSize;
    private int activeCount;
    private final RunnableQueue runnableQueue;
    private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();
    private volatile boolean isShutdown = false;
    private final long keepAliveTime;
    private final TimeUnit timeUnit;

    public BasicThreadPool(int initSize, int maxSize, int coreSize,int queueSize) {
        this(initSize,maxSize,coreSize,DEFAULT_THREAD_FACTORY,queueSize,
            DEFAULT_DENY_POLICY,10, TimeUnit.SECONDS);
    }

    public BasicThreadPool(int initSize, int maxSize, int coreSize,ThreadFactory threadFactory, int queueSize,
                           DenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
        this.threadFactory = threadFactory;
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy,this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;

        this.init();
    }

    private void init() {
        start();

        for (int i = 0; i < initSize; i++) {
            newThread();
        }
    }

    private void newThread() {
        InternalTask internalTask = new InternalTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread, internalTask);
        threadQueue.offer(threadTask);
        activeCount++;
        thread.start();
    }

    private void removeThread() {
        ThreadTask threadTask = threadQueue.remove();
        threadTask.internalTask.stop();
        this.activeCount--;
    }

    @Override
    public void run() {
        while (!isShutdown && !isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                isShutdown = true;
                break;
            }

            synchronized (this) {
                if (isShutdown)
                    break;

                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = initSize; i < coreSize; i++) {
                        newThread();
                    }

                    continue;
                }

                if (runnableQueue.size() > 0 && activeCount < maxSize) {
                    for (int i = coreSize; i < maxSize; i++) {
                        newThread();
                    }
                }

                if (runnableQueue.size() == 0 && activeCount > coreSize) {
                    for (int i = coreSize; i < activeCount; i++) {
                        removeThread();
                    }
                }
            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown)
            throw new IllegalStateException("The thread pool is destroy.");
        this.runnableQueue.offer(runnable);
    }

    @Override
    public void shutdown() {
        synchronized (this) {
            if (isShutdown)
                return;

            isShutdown = true;
            threadQueue.forEach(threadTask -> {
                threadTask.internalTask.stop();
                threadTask.thread.interrupt();
            });

            this.interrupt();
        }
    }

    @Override
    public int getInitSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destory.");
        return this.initSize;
    }

    @Override
    public int getMaxSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destory.");
        return this.maxSize;
    }

    @Override
    public int getCoreSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destory.");
        return this.coreSize;
    }

    @Override
    public int getQueueSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destory.");
        return runnableQueue.size();
    }

    @Override
    public int getActiveCount() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destory.");
        return activeCount;
    }

    @Override
    public boolean isShutdown() {
        return this.isShutdown;
    }
}
