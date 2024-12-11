package org.example.src.factory.observer;

public class MetricsObserver implements DataObserver {
    private int readCount = 0;
    private int writeCount = 0;

    @Override
    public void onDataRead(String data) {
        readCount++;
        System.out.println("性能统计: 总读取次数 - " + readCount);
    }

    @Override
    public void onDataWrite(String data) {
        writeCount++;
        System.out.println("性能统计: 总写入次数 - " + writeCount);
    }
} 