package org.example.src.factory.adapter;

import org.example.src.factory.interfaces.DataSource;

public class DatabaseAdapter implements DataSource {
    @Override
    public String readLine() {
        // 数据库读取实现
        return null;
    }

    @Override
    public void writeLine(String line) {
        // 数据库写入实现
    }

    @Override
    public void close() {
        // 关闭数据库连接
    }
} 