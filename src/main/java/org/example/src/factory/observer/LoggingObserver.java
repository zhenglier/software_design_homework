package org.example.src.factory.observer;

public class LoggingObserver implements DataObserver {
    @Override
    public void onDataRead(String data) {
        System.out.println("日志记录: 读取数据 - " + data);
    }

    @Override
    public void onDataWrite(String data) {
        System.out.println("日志记录: 写入数据 - " + data);
    }
} 