package com.example.gctodoapp.executor;

import java.util.concurrent.Executor;

import javax.inject.Inject;

/**
 * Created by ThinhND
 */
public class AppExecutors {
    private final Executor diskIO;

    private final Executor mainThread;

    AppExecutors(Executor diskIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.mainThread = mainThread;
    }

    @Inject
    public AppExecutors() {
        this(new DiskIOThreadExecutor(),
                new MainThreadExecutor());
    }

    public Executor diskIO() {
        return diskIO;
    }


    public Executor mainThread() {
        return mainThread;
    }
}
